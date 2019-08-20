#include <unistd.h>
#include <sys/mman.h>
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

#define BUFFER_SIZE 1000
#define ALLOC_SIZE (100 * 1024 * 1024)

static char command[BUFFER_SIZE];

/* メモリ再割り当てのサンプルプログラム */
int main(void)
{
  pid_t pid;

  pid = getpid();
  // /proc/processid/maps にメモリマップ情報がある
  snprintf(command, BUFFER_SIZE, "cat /proc/%d/maps", pid);

  //printf(command);

  puts("*** memory map before memory allocation ***");
  fflush(stdout);   // バッファをフラッシュする
  system(command);  // この時点でのメモリマップを取得して表示

  void *new_memory;

  // nmap(システムコール)でメモリにマップする。つまりページテーブルが作成されるという理解であってるはず
  // mallocは内部的にはmmapを呼ぶ
  new_memory = mmap(NULL, ALLOC_SIZE, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);

  if (new_memory == (void *) -1) {
    err(EXIT_FAILURE, "mmap() failed");
  }

  puts("");
  printf("*** succeeded to allocate memory: address = %p; size = 0x%x ***\n", new_memory, ALLOC_SIZE);
  puts("");

  puts("*** memory map after memory allocation ***");
  fflush(stdout);
  system(command);  // この時点でのメモリマップを取得して表示

  if (munmap(new_memory, ALLOC_SIZE) == -1) {
    err(EXIT_FAILURE, "munmap() failed");
  }

  exit(EXIT_SUCCESS);
}

/*
$ cc -o mmap mmap.c
$ ./mmap


*** memory map before memory allocation ***
7f933c600000-7f933c7e7000 r-xp 00000000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c7e7000-7f933c7f0000 ---p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c7f0000-7f933c9e7000 ---p 000001f0 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c9e7000-7f933c9eb000 r--p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c9eb000-7f933c9ed000 rw-p 001eb000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c9ed000-7f933c9f1000 rw-p 00000000 00:00 0
7f933ca00000-7f933ca26000 r-xp 00000000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933ca26000-7f933ca27000 r-xp 00026000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933cc27000-7f933cc28000 r--p 00027000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933cc28000-7f933cc29000 rw-p 00028000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933cc29000-7f933cc2a000 rw-p 00000000 00:00 0
7f933ce10000-7f933ce12000 rw-p 00000000 00:00 0
7f933d000000-7f933d001000 r-xp 00000000 00:00 1253632            /mnt/c/Users/learn/monooki/infrastructure/linux/5/mmap
7f933d200000-7f933d201000 r--p 00000000 00:00 1253632            /mnt/c/Users/learn/monooki/infrastructure/linux/5/mmap
7f933d201000-7f933d202000 rw-p 00001000 00:00 1253632            /mnt/c/Users/learn/monooki/infrastructure/linux/5/mmap
7fffc122f000-7fffc1250000 rw-p 00000000 00:00 0                  [heap]
7fffc7e90000-7fffc8690000 rw-p 00000000 00:00 0                  [stack]
7fffc8bec000-7fffc8bed000 r-xp 00000000 00:00 0                  [vdso]

*** succeeded to allocate memory: address = 0x7f9336200000; size = 0x6400000 ***   <<< mmapでメモリマップしたもの

*** memory map after memory allocation ***
7f9336200000-7f933c600000 rw-p 00000000 00:00 0                  <<< mmapでメモリマップしたもの （開始アドレス-終了アドレス）
7f933c600000-7f933c7e7000 r-xp 00000000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c7e7000-7f933c7f0000 ---p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c7f0000-7f933c9e7000 ---p 000001f0 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c9e7000-7f933c9eb000 r--p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c9eb000-7f933c9ed000 rw-p 001eb000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f933c9ed000-7f933c9f1000 rw-p 00000000 00:00 0
7f933ca00000-7f933ca26000 r-xp 00000000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933ca26000-7f933ca27000 r-xp 00026000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933cc27000-7f933cc28000 r--p 00027000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933cc28000-7f933cc29000 rw-p 00028000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f933cc29000-7f933cc2a000 rw-p 00000000 00:00 0
7f933ce10000-7f933ce12000 rw-p 00000000 00:00 0
7f933d000000-7f933d001000 r-xp 00000000 00:00 1253632            /mnt/c/Users/learn/monooki/infrastructure/linux/5/mmap
7f933d200000-7f933d201000 r--p 00000000 00:00 1253632            /mnt/c/Users/learn/monooki/infrastructure/linux/5/mmap
7f933d201000-7f933d202000 rw-p 00001000 00:00 1253632            /mnt/c/Users/learn/monooki/infrastructure/linux/5/mmap
7fffc122f000-7fffc1250000 rw-p 00000000 00:00 0                  [heap]
7fffc7e90000-7fffc8690000 rw-p 00000000 00:00 0                  [stack]
7fffc8bec000-7fffc8bed000 r-xp 00000000 00:00 0                  [vdso]
 */
