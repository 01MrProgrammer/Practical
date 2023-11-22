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
   printf("\nProcess Id :%d",pid);
   ChildProcess();
   printf("\n");
 }
 else
 {
   printf("\nProcess Id:%d",pid);
   ParentProcess();
   printf("\n");
  }
 return 0;
}
void ChildProcess()
{
 printf("\nI am child Process...");
}
void ParentProcess()
{
 printf("\nI am parent process...");
}
