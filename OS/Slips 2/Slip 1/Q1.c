#include<stdio.h>
#include<sys/types.h>

void ChildProcess();
void ParentProcess();

int main()
{
    pid_t pid;
    pid=fork();
    if(pid==0)
    {
        printf(" process ID: %d",pid);
        ChildProcess();
    }
   else
    {
        printf("process Id : %d",pid);
        ParentProcess();
    }
    return 0;
}

void ChildProcess()
{
    printf("\n I am child process");
}

void ParentProcess()
{
    printf("\n I am parent process\n");
}

