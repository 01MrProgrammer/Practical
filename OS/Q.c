#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<sys/wait.h>

#define MAX_INPUT_SIZE 1024

void execute_command(char *command){
    pid_t pid;
    int status;
    pid=fork();
    
    if(pid<0){
        perror(" fork failed");
        exit(EXIT_FAILURE);
    }
    
    else if(pid==0){
        char *args[MAX_INPUT_SIZE];
        int i=0;
        char *token=strtok(command, "\t\n");
        
        while(token!=NULL){
            args[i++]=token;
            token=strtok(NULL,"\t\n");
        } args[i]=NULL;
        
        if(execvp(args[0],args)==-1){
            perror("ERROR EXECUTING COMMAND");
            exit(EXIT_FAILURE);
            
        }
    }
        else{
            waitpid(pid,&status,0);
            if(WIFEXITED(status)){
                printf("THE CHILD PROCESS TERMINATED WITH STATUS:%d",WEXITSTATUS(status));
            }
        }
    }
    


int main(){
 char input[MAX_INPUT_SIZE];
 while(1){
     printf("myshell$:  ");
     fflush(stdout);
 
  if(fgets(input,sizeof(input),stdin)==NULL);{
  perror("Invalid Input");
  exit(EXIT_FAILURE);
  }
  execute_command(input);
  
 }  return 0;
}