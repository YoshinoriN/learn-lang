#include <unistd.h>
#include <sys/mman.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

#define CACHE_LINE_SIZE	64
#define NLOOP (4*1024UL*1024*1024)
#define NSECS_PER_SEC 1000000000UL

static inline diff_nsec(struct timespec before, struct timespec after)
{
  return ((after.tv_sec * NSECS_PER_SEC + after.tv_nsec) - (before.tv_sec * NSECS_PER_SEC + before.tv_nsec));
}

int main(int argc, char *argv[])
{
  char *progname;
  progname = argv[0];

  if (argc != 2) {
    fprintf(stderr, "usage: %s <size[KB]>\n", progname);
    exit(EXIT_FAILURE);
  }

  register int size;
  // atoi ... 文字列を数値に変換
  size = atoi(argv[1]) * 1024;
  if (!size) {
    fprintf(stderr, "size should be >= 1: %d\n", size);
    exit(EXIT_FAILURE);
  }

  char *buffer;

  /*
    mmapのフラグについて
    https://linuxjm.osdn.jp/html/LDP_man-pages/man2/mmap.2.html
   */
  buffer = mmap(NULL, size, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS, -1 , 0);
  if (buffer == (void *) -1) {
    err(EXIT_FAILURE, "mmap() failed");
  }

  struct timespec before, after;

  clock_gettime(CLOCK_MONOTONIC, &before);

  int i;
  for (i = 0; i < NLOOP / (size / CACHE_LINE_SIZE); i++) {
    long j;
    for (j =0; j < size; j += CACHE_LINE_SIZE) {
      buffer[j] = 0;
    }
  }

  clock_gettime(CLOCK_MONOTONIC, &after);

  printf("%f\n", (double)diff_nsec(before, after) / NLOOP);

  if (munmap(buffer, size) == -1) {
    err(EXIT_FAILURE, "munmap() failed");
  }

  exit(EXIT_SUCCESS);

}

/*
// -O3は最適化オプション
$ cc -O3 -o cache cache.c
 */
