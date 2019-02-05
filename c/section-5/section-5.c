// section-5.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdafx.h"

//数値の記憶と計算
int main()
{
	//先頭でだけ宣言可能
	int i = 10;
	int l = 200;
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

	//キャスト
	printf("%d\n", (int)(1.08 * 360));
	//キャストしない場合
	printf("%f\n", 1.08 * 360);

	//桁数をそろえる
	printf("iは %3d です。 \n", i);
	printf("lは %3d です。 \n", l);
	printf("kは %3d です。 \n", k);

	//0埋めする
	printf("iは %03d です。 \n", i);
	printf("lは %03d です。 \n", l);
	printf("kは %03d です。 \n", k);

    return 0;
}

