#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct process_info
{
	char pname[20];
	int at,bt,ct,bt1;
	struct process_info*next;
}NODE;

	int n;
	NODE * first,*last;
	void accept_info()
{
	NODE*p;
	int i;
	printf("Enter Number of process");
	scanf("%d",&n);		
	for(i=0;i<n;i++)
	{
		p=(NODE*)malloc(sizeof(NODE));
		printf("Enter process name");
		scanf("%s",p->pname);
		printf("Enter a arrival time:");
		scanf("%d",p->at);
		printf("Enter Cpu first burst time:");
		scanf("%d",p->bt);
		p->bt1=p->bt;
		p->next=NULL;
		if(first==NULL)
		first=p;
		else
		last->next=p;
		last=p;
	}
}

void print_output()
{
	NODE*p;
	float avg_tat=0,avg_wt=0;
	printf("pname \tat\tbt\tct\ttat\twt\n");
	p=first;
	while(p!=NULL)
	{
		int tat=p->ct_p->at;
		int wt=tat-p->bt;
		avg_tat+=tat;
		avg_wt+=wt;
		printf("%s\t%d\t%d\t%d\t%d\t%d\n",p->pname,p->bt,p->ct,p->at,p->tat,wt);
		p=p->next;
	}
	printf("avg TAT=%f\tavg wt=%f\n",avg_tat\n,avg_wt\n);
}

void print_input()
{
	NODE*p;
	p=first;
	printf("pname\tat\tbt\n");
	while(p!=NULL)
	{
		printf("%s\t%d\t%d\n",p->pname,p->at,p->bt1);
		p=p->next;
	}
}

void sort()
{
NODE*p,*q;
int t    




   
