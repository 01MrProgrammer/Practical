#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
int main()
{
    int pid;
    printf("\n current process is %d \n",getpid());
    pid=fork();
    if(pid<0)
    {
        printf("\n process can not be created....");
    }
    else  if(pid==0)
    {
        printf("\n child process...");
        printf("\n child process id:%d",getpid());
    } 
    else
    {
        wait(NULL);
        sleep(1);
        printf("\n parent process...\n orphan's child parent Id :%d",getppid());
   }
   return 0;
}
