// コピーオンライト

#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/mman.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <err.h>

#define BUFFER_SIZE (100 * 1024 * 1024)
#define PAGE_SIZE 4096
#define COMMAND_SIZE 4096

static char command[COMMAND_SIZE];

static void child_fn(char *p) {
  printf("*** child ps info before memory access ***:\n");

  fflush(stdout);

  snprintf(command, COMMAND_SIZE, "ps -o pid,comm,vsz,rss,min_flt,maj_flt | grep '^ *%d'", getpid());

  system(command);
  printf("*** free memory info before memory access ***:\n");
  fflush(stdout);
  system("free");

  int i;
  // この前の部分まではfork実行しても親子でメモリが共有される
  // 確保した仮想メモリの全てのページにアクセス（物理メモリが確保される）
  for (i = 0; i < BUFFER_SIZE; i += PAGE_SIZE) {
    p[i] = 0;
  }

  printf("*** child ps info after memory access ***:\n");
  fflush(stdout);
  system(command);

  printf("*** free memory info after memory access ***:\n");
  fflush(stdout);
  system("free");

  exit(EXIT_SUCCESS);
}

static void parent_fn(void) {
  // 子プロセスの終了を待つ
  wait(NULL);
  exit(EXIT_SUCCESS);
}

int main(void)
{
  char *p;
  // 100MB分の仮想メモリ割り当て
  p = malloc(BUFFER_SIZE);

  if (p == NULL) {
    err(EXIT_FAILURE, "malloc() failed");
  }

  printf("*** free memory info before fork ***:\n");
  fflush(stdout);
  system("free");

  pid_t forkProcessId;
  forkProcessId = fork();

  if (forkProcessId == -1) {
    err(EXIT_FAILURE, "fork() failed");
  }

  if (forkProcessId == 0) {
    child_fn(p);
  } else {
    parent_fn();
  }

  err(EXIT_FAILURE, "Could not reach here");
}

/*

$ cc -o copy-on-write copy-on-write.c
$ ./copy-on-write

*** free memory info before fork ***:
              total        used        free      shared  buff/cache   available
Mem:       16618884     5726812    10662720       17720      229352    10758340
Swap:      50331648      199132    50132516

*** child ps info before memory access ***:
   45 copy-on-write   112948   192      0      0
*** free memory info before memory access ***:

              total        used        free      shared  buff/cache   available
Mem:       16618884     5726884    10662648       17720      229352    10758268
Swap:      50331648      199132    50132516

*** child ps info after memory access ***:
   45 copy-on-write   112948 102592     0      0
*** free memory info after memory access ***:

              total        used        free      shared  buff/cache   available
Mem:       16618884     5831316    10558216       17720      229352    10653836
Swap:      50331648      199132    50132516

 */
