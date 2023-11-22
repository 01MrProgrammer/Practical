#include<stdio.h>
#include<sys/types.h>
void ParentProcess();
int main()
{
 pid_t pid;
 pid=fork();
 if(pid==0)
 {
  execlp("./data/ty120/TYBSc(Computer Science)_120/OS/assi_no_1/Set A q1",NULL);

 }
 else
 {
   ParentProcess();
  }
 return 0;
}
void ParentProcess()
{
 printf("\nI am parent process...\n");
}
