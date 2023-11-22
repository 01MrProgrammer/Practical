#include<stdio.h>
#include<sys/types.h>
#include<stdlib.h>
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
 int arr[30],arr1[30],n,i;
 printf("Enter size of array:");
 scanf("%d",&n);
 printf("Enter the array elements:");
 for(i=0;i<n;i++)
 {
   scanf("%d",&arr[i]);
  }
 int pid=fork();
 if (pid==0)
 {                                               
   sleep(1);
   printf("\nChild process");
   printf("\nChild process id=%d\n",getpid());
   insertion(arr,n);
   printf("Element sorted using insertion sort : ");
   for(i=0;i<n;i++)
   {
     printf("%d\t",arr[i]);
    }
  }
 else if(pid>0)
 {
   wait(NULL);
   sleep(1);
   printf("\n\nParent process id=%d",getppid());
   bubblesort(arr,n);
   printf("\nElements sorted using bubblesort : ");
   for(i=0;i<n;i++)
   printf("%d\t",arr[i]);
    printf("\n");
   }
}
                                                
