// section-5.cpp : �R���\�[�� �A�v���P�[�V�����̃G���g�� �|�C���g���`���܂��B
//

#include "stdafx.h"

//���l�̋L���ƌv�Z
int main()
{
	//�擪�ł����錾�\
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

	//�ϐ���p�����v�Z
	printf("%f\n", j + k);
	printf("%f\n", j - k);
	printf("%f\n", j * k);
	printf("%f\n", j / k);

	//�L���X�g
	printf("%d\n", (int)(1.08 * 360));
	//�L���X�g���Ȃ��ꍇ
	printf("%f\n", 1.08 * 360);

	//���������낦��
	printf("i�� %3d �ł��B \n", i);
	printf("l�� %3d �ł��B \n", l);
	printf("k�� %3d �ł��B \n", k);

	//0���߂���
	printf("i�� %03d �ł��B \n", i);
	printf("l�� %03d �ł��B \n", l);
	printf("k�� %03d �ł��B \n", k);

    return 0;
}

