// section-6.cpp : �R���\�[�� �A�v���P�[�V�����̃G���g�� �|�C���g���`���܂��B
//

#include <stdio.h>


int main(void)
{
	int data, data2, data3;
	//���͂����f�[�^��\������
	//scanf_s("%d%d", &data, &data2);
	//printf("%d, %d\n", data, data2);

	//��؂蕶�����w�肷�邱�Ƃ��\
	//���L�̓J���}��؂�ɂ��Ă���
	//scanf_s("%d,%d", &data, &data2);

	//�ȈՃV�O�}�v�Z
	printf("�ŏ��l�ƍő�l���J���}�ŋ�؂��ē��͂��Ă������� : ");
	scanf_s("%d, %d", &data, &data2);

	data3 = (data + data2) * (data2 - data + 1) / 2;
	printf("%d�`%d �̍��v�� %d �ł��B", data, data2, data3);

    return 0;
}

