// section-7.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdio.h"


int main(void)
{
	//比較演算子
	int suuchi;
	scanf_s("%d", &suuchi);
	if (suuchi == 10) printf("入力値は10です！！！");
	if (suuchi != 10) printf("入力値は10じゃないです！！！");
	if (suuchi > 10) printf("入力値は10よりでっかい！！！");
	if (suuchi < 10) printf("入力値は10よりちっさい！！！");

    return 0;
}

