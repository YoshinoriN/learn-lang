#include <unistd.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <err.h>

#define BUFFER_SIZE (100 * 1024 * 1024)
#define NCYCLE 10
#define PAGE_SIZE 4096

/**
 * デマンドページングのサンプルプログラム
 * 仮想アドレスだけ割り当てて物理メモリは実行時（仮想アドレスにアクセスした時）に割り当て
 *
 */
int main(void)
{
  char *p;
  time_t t;
  char *s;

  t = time(NULL);
  s = ctime(&t); // 日時の文字列

  printf("%.*s: before allocation, please press Enter key\n", (int)(strlen(s) - 1), s);
  getchar();

  // メモリ割り当て（Linuxの場合デマンドページングなのでこの時点では仮想アドレスのみの割り当てになる）
  p = malloc(BUFFER_SIZE);
  if (p == NULL) {
    err(EXIT_FAILURE, "malloc() failed");
  }

  t = time(NULL);
  s = ctime(&t);

  printf("%.*s: allocated %dMB, please press Enter key\n", (int)(strlen(s) - 1), s, BUFFER_SIZE / (1024 * 1024));
  getchar();

  int i;
  // 確保した仮想アドレスに1ページ(4096KB)ずつアクセスする
  for (i = 0; i < BUFFER_SIZE; i += PAGE_SIZE) {

    p[i] = 0;
    int cycle = i / (BUFFER_SIZE / NCYCLE);

    // 10MB確保すると進捗出力
    if (cycle != 0 && i % (BUFFER_SIZE / NCYCLE) == 0) {
      t = time(NULL);
      s = ctime(&t);
      printf("%.*s: touched %dMB\n", (int) (strlen(s) - 1), s, i / (1024*1024));
      sleep(1);
    }
  }

  t = time(NULL);
  s = ctime(&t);
  printf("%.*s: touched %dMB, please press Enter key\n", (int) (strlen(s) - 1), s, BUFFER_SIZE / (1024 * 1024));
  getchar();

  exit(EXIT_SUCCESS);
}

/*
$ cc -o demand-paging demand-paging.c
$ ./demand-paging

Tue Aug 27 22:40:49 2019: before allocation, please press Enter key

Tue Aug 27 22:40:52 2019: allocated 100MB, please press Enter key

Tue Aug 27 22:40:54 2019: touched 10MB
Tue Aug 27 22:40:55 2019: touched 20MB
Tue Aug 27 22:40:56 2019: touched 30MB
Tue Aug 27 22:40:57 2019: touched 40MB
Tue Aug 27 22:40:58 2019: touched 50MB
Tue Aug 27 22:40:59 2019: touched 60MB
Tue Aug 27 22:41:00 2019: touched 70MB
Tue Aug 27 22:41:01 2019: touched 80MB
Tue Aug 27 22:41:02 2019: touched 90MB
Tue Aug 27 22:41:03 2019: touched 100MB, please press Enter key

----------------------------------------------------------------

sarでメモリ撮りながら試す

$ sar -r 1

10:47:21 PM kbmemfree   kbavail kbmemused  %memused kbbuffers  kbcached  kbcommit   %commit  kbactive   kbinact   kbdirty

// 既に仮想アドレス100MB割り当てているが kbmemusedはまだそんなに減ってない
10:47:22 PM   9339112         0   7279772     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:23 PM   9339328         0   7279556     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:24 PM   9339332         0   7279552     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:25 PM   9339680         0   7279204     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:26 PM   9339688         0   7279196     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:27 PM   9339704         0   7279180     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:28 PM   9339696         0   7279188     43.80     34032    188576   3450064      5.15    167556    157876         0

// 実際に物理メモリ確保しだしてから
10:47:29 PM   9339916         0   7278968     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:30 PM   9339932         0   7278952     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:31 PM   9339992         0   7278892     43.80     34032    188576   3450064      5.15    167556    157876         0
10:47:32 PM   9327828         0   7291056     43.87     34032    188576   3450064      5.15    167556    157876         0
10:47:33 PM   9323212         0   7295672     43.90     34032    188576   3450064      5.15    167556    157876         0
10:47:34 PM   9308752         0   7310132     43.99     34032    188576   3450064      5.15    167556    157876         0
10:47:35 PM   9301128         0   7317756     44.03     34032    188576   3450064      5.15    167556    157876         0
10:47:36 PM   9293736         0   7325148     44.08     34032    188576   3450064      5.15    167556    157876         0
10:47:37 PM   9275364         0   7343520     44.19     34032    188576   3450064      5.15    167556    157876         0
10:47:38 PM   9265708         0   7353176     44.25     34032    188576   3450064      5.15    167556    157876         0
10:47:39 PM   9255020         0   7363864     44.31     34032    188576   3450064      5.15    167556    157876         0

// プロセス終了後
10:47:40 PM   9245496         0   7373388     44.37     34032    188576   3450064      5.15    167556    157876         0
10:47:41 PM   9232904         0   7385980     44.44     34032    188576   3450064      5.15    167556    157876         0
10:47:42 PM   9232856         0   7386028     44.44     34032    188576   3450064      5.15    167556    157876         0
10:47:43 PM   9232840         0   7386044     44.44     34032    188576   3450064      5.15    167556    157876         0
10:47:44 PM   9232924         0   7385960     44.44     34032    188576   3450064      5.15    167556    157876         0
10:47:45 PM   9331660         0   7287224     43.85     34032    188576   3450064      5.15    167556    157876         0
 */
