// section-5.cpp : �R���\�[�� �A�v���P�[�V�����̃G���g�� �|�C���g���`���܂��B
//

#include "stdafx.h"

//���l�̋L���ƌv�Z
int main()
{
	//�擪�ł����錾�\
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

	//�ϐ���p�����v�Z
	printf("%f\n", j + k);
	printf("%f\n", j - k);
	printf("%f\n", j * k);
	printf("%f\n", j / k);

    return 0;
}

