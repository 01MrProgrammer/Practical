#include<stdio.h>
struct frmnode
{
	int pno;
}frames[20];

int n;
int page_found(int pno)
{
	int fno;
	for(fno=0;fno<n;fno++)
	{
		if(frames[fno].pno==pno)
			return fno;
	}
	return -1;
}

int get_free_frame()
{
	int fno;
	for(fno=0;fno<n;fno++)
	{
		if(frames[fno].pno==-1)
			return(fno);
	}
	return(-1);
}

int get_fifo_frame()
{
	static int fno=-1;
	fno=(fno+1)%n;
	return fno;
}

int main()
{
	int p_request[]={12,15,12,18,6,8,11,12,19,12,6,8,12,15,19,8};
	int size=sizeof(p_request)/sizeof(int);
	printf("%d",size);
	int page_fault=0,i,j,fno;
	printf("\n How Many Frames :");
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
	{
		frames[i].pno=-1;
	}
	printf("\nPageNo PageFrames PageFault");
	printf("\n-----------------------------");
	
	for(i=0;i<size;i++)
	{
		j=page_found(p_request[i]);
		if(j==-1)
		{
			page_fault++;
			j=get_free_frame();
			if(j==-1)
				j=get_fifo_frame();
				frames[j].pno=p_request[i];
			printf("\n %4d \t",p_request[i]);	
			for(fno=0;fno<n;fno++)
				printf("%4d",frames[fno].pno);
				printf(": YES");
		}
		else
		{
			printf("\n %4d \t",p_request[i]);
			for(fno=0;fno<n;fno++)
				printf("%4d",frames[fno].pno);
				printf(": NO");
		}
	}
	printf("\n----------------------------------");
	printf("\n Number of Page_Faults=%d",page_fault);
	printf("\n");
}