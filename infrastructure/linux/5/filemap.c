#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/mman.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <err.h>

#define BUFFER_SIZE 1000
#define ALLOC_SIZE (100 * 1024 * 1024)

static char command[BUFFER_SIZE];
static char file_contents[BUFFER_SIZE];
static char overwrite_data[] = "HELLO";

/**
 * ファイルマップのサンプルプログラム
 *
 * 実行後にtestfileの中身がHELLOに更新される
 */
int main(void)
{
  pid_t pid;

  pid = getpid();
  snprintf(command, BUFFER_SIZE, "cat /proc/%d/maps", pid);

  puts("*** memory map before mapping file ***");
  fflush(stdout);
  system(command);

  int fd;
  fd = open("testfile", O_RDWR); // ファイルディスクリプタを返す

  //printf("%d\n", fd);

  if (fd == -1) {
    err(EXIT_FAILURE, "open() failed");
  }

  char * file_contents;
  file_contents = mmap(NULL, ALLOC_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

  if (file_contents == (void *) -1) {
    warn("mmap() failed");
    goto close_file;
  }

  puts("");
  printf("*** succeeded to map file: address = %p; size = 0x%x ***\n", file_contents, ALLOC_SIZE);

  puts("");
  puts("*** memory map after mapping file ***");
  fflush(stdout);
  system(command);

  puts("");
  printf("*** file contens before overwrite mapped region: %s", file_contents);

  // 第二引数を第三引数のバイト数だけ第一引数にコピーする
  memcpy(file_contents, overwrite_data, strlen(overwrite_data));

  puts("");
  printf("*** overwritten mapped region with: %s\n", file_contents);

  if (munmap(file_contents, ALLOC_SIZE) == -1) {
    warn("munmap() failed");
  }

close_file:
  if (close(fd) == -1) {
    warn("close() failed");
  }
  exit(EXIT_SUCCESS);
}

/*
$ cc -o filemap filemap.c
$ ./filemap

*** memory map before mapping file ***
7f215e200000-7f215e3e7000 r-xp 00000000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e3e7000-7f215e3f0000 ---p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e3f0000-7f215e5e7000 ---p 000001f0 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e5e7000-7f215e5eb000 r--p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e5eb000-7f215e5ed000 rw-p 001eb000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e5ed000-7f215e5f1000 rw-p 00000000 00:00 0
7f215e600000-7f215e626000 r-xp 00000000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e626000-7f215e627000 r-xp 00026000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e827000-7f215e828000 r--p 00027000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e828000-7f215e829000 rw-p 00028000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e829000-7f215e82a000 rw-p 00000000 00:00 0
7f215e950000-7f215e952000 rw-p 00000000 00:00 0
7f215ea00000-7f215ea01000 r-xp 00000000 00:00 1253957            /mnt/c/Users/learn/monooki/infrastructure/linux/5/filemap
7f215ec01000-7f215ec02000 r--p 00001000 00:00 1253957            /mnt/c/Users/learn/monooki/infrastructure/linux/5/filemap
7f215ec02000-7f215ec03000 rw-p 00002000 00:00 1253957            /mnt/c/Users/learn/monooki/infrastructure/linux/5/filemap
7fffdfc85000-7fffdfca6000 rw-p 00000000 00:00 0                  [heap]
7fffe63dd000-7fffe6bdd000 rw-p 00000000 00:00 0                  [stack]
7fffe6fe3000-7fffe6fe4000 r-xp 00000000 00:00 0                  [vdso]

*** succeeded to map file: address = 0x7f2157e00000; size = 0x6400000 ***

*** memory map after mapping file ***
7f2157e00000-7f2157e01000 rw-s 00000000 00:00 1253956            /mnt/c/Users/learn/monooki/infrastructure/linux/5/testfile  <<< テストファイルをマップした
7f2157e01000-7f215e200000 rw-p 00000001 00:00 1253956            /mnt/c/Users/learn/monooki/infrastructure/linux/5/testfile  <<< テストファイルをマップした
7f215e200000-7f215e3e7000 r-xp 00000000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e3e7000-7f215e3f0000 ---p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e3f0000-7f215e5e7000 ---p 000001f0 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e5e7000-7f215e5eb000 r--p 001e7000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e5eb000-7f215e5ed000 rw-p 001eb000 00:00 281184             /lib/x86_64-linux-gnu/libc-2.27.so
7f215e5ed000-7f215e5f1000 rw-p 00000000 00:00 0
7f215e600000-7f215e626000 r-xp 00000000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e626000-7f215e627000 r-xp 00026000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e827000-7f215e828000 r--p 00027000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e828000-7f215e829000 rw-p 00028000 00:00 281064             /lib/x86_64-linux-gnu/ld-2.27.so
7f215e829000-7f215e82a000 rw-p 00000000 00:00 0
7f215e950000-7f215e952000 rw-p 00000000 00:00 0
7f215ea00000-7f215ea01000 r-xp 00000000 00:00 1253957            /mnt/c/Users/learn/monooki/infrastructure/linux/5/filemap
7f215ec01000-7f215ec02000 r--p 00001000 00:00 1253957            /mnt/c/Users/learn/monooki/infrastructure/linux/5/filemap
7f215ec02000-7f215ec03000 rw-p 00002000 00:00 1253957            /mnt/c/Users/learn/monooki/infrastructure/linux/5/filemap
7fffdfc85000-7fffdfca6000 rw-p 00000000 00:00 0                  [heap]
7fffe63dd000-7fffe6bdd000 rw-p 00000000 00:00 0                  [stack]
7fffe6fe3000-7fffe6fe4000 r-xp 00000000 00:00 0                  [vdso]

*** file contens before overwrite mapped region: hello

*** overwritten mapped region with: HELLO

 */
