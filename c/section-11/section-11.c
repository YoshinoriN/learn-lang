// section-11.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdio.h"

//コンパイラは上から順番にコンパイルするのでこの関数は呼び出し元の関数（main）より先に記述しなければいけない
//ただし、先頭であらかじめ関数の型を記述することで同様のことが実現できる。これをプロトタイプ宣言という
//includeも同様である。printfなどの関数は stdio.h ファイル内に記述されている。

int sum(int, int);  //プロトタイプ宣言

int main(void)
{
	int val = sum(50, 100);      //関数呼び出し
	printf("%d\n", val);
    return 0;
}

int sum(int min, int max)
{
	return ((min + max) * (max - min + 1) / 2);
}
