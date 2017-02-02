// Kuru-C.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdio.h"


int main()
{
	printf("hello world");

	//改行
	printf("\n");
	printf("改行\n");
	printf("し\n");
	printf("マクリスティ！\n\n");
	printf("マクリスティ！\n");
	printf("マクリスティ！\n");
	
	//インデントそろえる
	printf("マクリスティ！\tマクリスティ！\n");
	printf("マクリスティ！\tマクリスティ！\n");

	//数値
	printf("%d", 1900);
	printf("\n%d年", 1900);

	printf("\n%d+%d=%d\n", 100, 200, 300, "\n\n");
    return 0;
}

