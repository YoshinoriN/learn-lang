// section-8.cpp : �R���\�[�� �A�v���P�[�V�����̃G���g�� �|�C���g���`���܂��B
//

#include "stdio.h"

//�������򂻂�2
int main()
{
	int i;
	scanf_s("%d", &i);

	if (i == 10)
	{
		printf("���͒l��10�I�I�I\n\n");
	}
	else
	{
		printf("���͒l��10���Ⴄ\n\n");
	}

	//�����l�����g���Ȃ�
	switch (i)
	{
	case 1:
		printf("����");
		break;
	case 2:
		printf("��");
		break;
	case 3:
		printf("����");
		break;
	case 4:
		printf("���");
		break;
	case 5:
		printf("��");
		break;
	case 6:
	case 7:
	case 8:
		printf("�낭�`�͂�");
		break;
	default:
		printf("���̑�");
		break;
	}

    return 0;
}

