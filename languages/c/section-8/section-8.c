// section-8.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include "stdio.h"

//条件分岐その2
int main()
{
	int i;
	scanf_s("%d", &i);

	if (i == 10)
	{
		printf("入力値は10！！！\n\n");
	}
	else
	{
		printf("入力値は10ちゃう\n\n");
	}

	//整数値しか使えない
	switch (i)
	{
	case 1:
		printf("いち");
		break;
	case 2:
		printf("に");
		break;
	case 3:
		printf("さん");
		break;
	case 4:
		printf("よん");
		break;
	case 5:
		printf("ご");
		break;
	case 6:
	case 7:
	case 8:
		printf("ろく～はち");
		break;
	default:
		printf("その他");
		break;
	}

    return 0;
}

