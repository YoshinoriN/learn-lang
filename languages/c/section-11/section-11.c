// section-11.cpp : �R���\�[�� �A�v���P�[�V�����̃G���g�� �|�C���g���`���܂��B
//

#include "stdio.h"

//�R���p�C���͏ォ�珇�ԂɃR���p�C������̂ł��̊֐��͌Ăяo�����̊֐��imain�j����ɋL�q���Ȃ���΂����Ȃ�
//�������A�擪�ł��炩���ߊ֐��̌^���L�q���邱�Ƃœ��l�̂��Ƃ������ł���B������v���g�^�C�v�錾�Ƃ���
//include�����l�ł���Bprintf�Ȃǂ̊֐��� stdio.h �t�@�C�����ɋL�q����Ă���B

int sum(int, int);  //�v���g�^�C�v�錾

int main(void)
{
	int val = sum(50, 100);      //�֐��Ăяo��
	printf("%d\n", val);
    return 0;
}

int sum(int min, int max)
{
	return ((min + max) * (max - min + 1) / 2);
}
