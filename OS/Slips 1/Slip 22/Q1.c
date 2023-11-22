#include<stdio.h>
#include<sys/types.h>
void main()
 {
   pid_t pid;
   int retnice;
   retnice=nice(2);
   pid=fork();
   if(pid==0)
   { 
     retnice=nice(5);
     printf("child get higher cpu priority  %d\n",retnice);
   }
     else
   {
      retnice=nice(10);   
      printf("parent get lower cpu priority %d \n",retnice);
      sleep(1);
  }
 }
