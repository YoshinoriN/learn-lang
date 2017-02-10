// section-6.cpp : コンソール アプリケーションのエントリ ポイントを定義します。
//

#include <stdio.h>


int main(void)
{
	int data, data2, data3;
	//入力したデータを表示する
	//scanf_s("%d%d", &data, &data2);
	//printf("%d, %d\n", data, data2);

	//区切り文字を指定することも可能
	//下記はカンマ区切りにしている
	//scanf_s("%d,%d", &data, &data2);

	//簡易シグマ計算
	printf("最小値と最大値をカンマで区切って入力してください : ");
	scanf_s("%d, %d", &data, &data2);

	data3 = (data + data2) * (data2 - data + 1) / 2;
	printf("%d～%d の合計は %d です。", data, data2, data3);

    return 0;
}

