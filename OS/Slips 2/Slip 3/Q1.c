#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
void bubblesort(int arr[],int n)
 {
   int i,j,temp;
   for(i=0;i<n;i++)
    {
     for(j=0;j<n-1;j++)
      {
         if(arr[j]>arr[j+1])
       {
           temp=arr[j];
           arr[j]=arr[j+1];
           arr[j+1]=temp;
        }
     }
   }
 }
   void insertion(int arr[],int n)
 {
   int i,j,temp;
   for(i=1;i<n;i++)
   {
     temp=arr[i];
     j=i-1;
     while(j>=0 && temp<=arr[j])
   {
      arr[j+1]=arr[j];
      j=j-1;
   }
    arr[j+1]=temp; 
  } 
 } 
   void main()
  {
    int arr[30], arr1[30],n,i,j;
    printf("enter the size of array:");
    scanf("%d",&n);
    printf("enter the array element:");
    for(i=0;i<n;i++)
    scanf("%d",&arr[i]);
    int pid=fork();
    if (pid==0)
   {
     sleep(1);
     printf("\n child process");
     printf("\n child process id=%d \n", getpid());
     insertion(arr,n);
      printf("\n elements sorted by insertion sort:");
     for(i=0;i<n;i++)
      printf("%d\t", arr[i]);
    }
    else if(pid>0)
   {
      wait(NULL);
      sleep(1);
      printf("\n parent process");
      printf("\n parent process id= %d", getppid());
      bubblesort(arr,n);
      printf("\n elements are sorted by using bubble sort:");
      for(i=0;i<n;i++)
      printf(" %d \t",arr[i]);
  }
}


 