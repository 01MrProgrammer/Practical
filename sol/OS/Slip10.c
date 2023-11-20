
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <dirent.h>

/*Program for create own shell */
//list

char comm[100],*ptr;
char *args[10];
int tot;

int list( char *option, char *dirname);
main()
{
	do
	{
		printf("myshell$ ");
		getcomm();
		sep_arg();
		take_action();
	}while(1);
} // main

sep_arg()
{
	int i,j;
	char *token;	
	i = j = tot=0;
        	
	token=strtok(comm," ");	
	while(token!=NULL)
 	{
	  args[tot]=(char*)malloc(20); 
	  strcpy(args[tot++],token);
          token=strtok(NULL," ");
	}
 	return;
}


getcomm()
{
	int len;
	ptr = fgets(comm,80,stdin);
	len = strlen(comm);
	comm[len-1] = '\0';
	return;
} // getcomm

take_action()
{
	char str[100];
	pid_t   pid;
	int status;

		if ( strlen(comm) <= 1 )
			return;
 	        if(strcmp(args[0],"list") == 0 )
		     list(args[1],args[2]);
                else
		{ pid = fork();
		  if(  pid == 0 ) // child
		  {   
			execvp(args[0],args);
			strcpy(str,"./");
			strcat(str,args[0]);
			execvp(str,args);
			printf("\n%s : command not found",comm);
			exit(0);
		   } 
		   else //parent
		      waitpid(pid,&status,0); //wait for child
		}
}// take action



int list( char *option, char *dirname)
{
	DIR *dp;
	struct dirent *dent;
	int cnt;

	if(strcmp(option,"-f")==0)
	{
	 // list all dir entries
	  		dp= opendir(dirname);
			if( dp == NULL )
			{
				printf("\nUnable to open directory\n");
				return;
			}
			dent = readdir(dp);
			while( dent != NULL )
			{
				printf("\n%s",dent->d_name);
				dent= readdir(dp);
			}
			printf("\n");
	}
        else
	if(strcmp(option,"-n")==0)
	{
	  // list number all dir entries
			cnt =0;
			dp= opendir(dirname);
			if( dp == NULL )
			{
				printf("\nUnable to open dir");
				exit(0);
			}
			dent = readdir(dp);
			while( dent != NULL )
			{
				cnt++;
				dent= readdir(dp);
			}
			printf("\ntot dir entries = %d\n",cnt);
			closedir(dp);
	 }
	else
	if(strcmp(option,"-i")==0)
	{ // list all dir entries with inode
			dp= opendir(dirname);
			if( dp == NULL )
			{
				printf("\nUnable to open dir");
				exit(0);
			}
			dent = readdir(dp);
			while( dent != NULL )
			{
			  	printf("\n%s %ld",dent->d_name,dent->d_ino);
				dent= readdir(dp);
			
			}
			printf("\n");
			closedir(dp);
	 }
	 else
		printf("\nInvalid option\n");
	
	
	return(0);
}// main



