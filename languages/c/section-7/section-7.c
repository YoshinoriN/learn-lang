// section-7.cpp : �R���\�[�� �A�v���P�[�V�����̃G���g�� �|�C���g���`���܂��B
//

#include "stdio.h"


int main(void)
{
	//��r���Z�q
	int suuchi;
	scanf_s("%d", &suuchi);
	if (suuchi == 10) printf("���͒l��10�ł��I�I�I");
	if (suuchi != 10) printf("���͒l��10����Ȃ��ł��I�I�I");
	if (suuchi > 10) printf("���͒l��10���ł������I�I�I");
	if (suuchi < 10) printf("���͒l��10��肿�������I�I�I");

    return 0;
}

