#include <sys/types.h>
#include <unistd.h>

int main(void)
{
  for(;;)
  getppid();
}

/*
cc -o ppidloop ppidloop.c
./ppidloop &

$ sar -P ALL 1 1
$ kill pid
*/
