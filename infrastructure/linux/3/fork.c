#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

/* 自分のpidを出力して終了する */
static void child()
{
  printf("child pid is %d: ", getpid());
  exit(EXIT_SUCCESS);
}

/* 自分と子プロセスのpidを出力して終了する */
static void parent(pid_t pid_c)
{
  printf("Parent pid is %d and child pid is %d", getpid(), pid_c);
  exit(EXIT_SUCCESS);
}

int main(void)
{
  pid_t ret;
  ret = fork();
  if (ret == -1) {
    err(EXIT_FAILURE, "fork() failed");
  }
  if (ret == 0) {
    /* fork()は子プロセスの場合にpid = 0を返す */
    child();
  } else {
    parent(ret);
  }
  err(EXIT_FAILURE, "failed");
}

/*
$ cc -o fork fork.c
$ ./fork

*/
