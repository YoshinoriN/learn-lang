// section-5.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdafx.h"

//数値の記憶と計算
int main()
{
	//先頭でだけ宣言可能
	int i = 10;
	double j, k;
	j = 10;
	k = 3;

	printf("%d\n",i);
	i++;
	printf("%d\n", i);
	i--;
	i--;
	printf("%d\n", i);

	printf("\n\n");

	//変数を用いた計算
	printf("%f\n", j + k);
	printf("%f\n", j - k);
	printf("%f\n", j * k);
	printf("%f\n", j / k);

    return 0;
}

