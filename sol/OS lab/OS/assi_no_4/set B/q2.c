#include<stdio.h>
#define MAX 20
int frames[MAX],ref[MAX],mem[MAX][MAX],faults,sp,m,n,count[MAX];

void accept()
{
	int i;
	printf("Enter No of frames :");
	scanf("%d",&n);
	printf("Enter no of reference :");
	scanf("%d",&m);
	printf("Enter reference string :\n");
	for(i=0;i<m;i++)
	{
		printf("[%d]=",i);
		scanf("%d",&ref[i]);
	}
}

void disp()
{
	int i,j;
	for(i=0;i<m;i++)
	printf("%3d",ref[i]);
	printf("\n\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<m;j++)
		{
			if(mem[i][j])
			printf("%3d",mem[i][j]);
			else
			printf("\n");
		}
		printf("\n");
	}
	printf("Total page faults:%d\n",faults);
}

int search(int pno)
{
	int i;
	for(i=0;i<n;i++)
	{
		if(frames[i]==pno)
		return i;
	}
	return -1;
}

int get_mfu(int sp)
{
	int i,max j,max=-9999;
	i=sp;
	do
	{
	if(count[i]>max)
	{
	max=count[i];
	max_i=i;
	}
	i(i+1)%n;
	}while(i!=sp)
	return max_i;
}

void mfu()
{
	int i,j,k;
	for(i=0;i<n&&sp<n;i++)
	{
		k=search(ref[i])
		if(k==-1)
		{
		frames[sp]=ref;[i];
		count[sp]++;
		faults++
		sp++
		for(j=0;j<n;j++)
		mem[j][i]=frames[j];
	}
	else
	count[k]++;
	}
	sp=0;
	for(j=0;)




































