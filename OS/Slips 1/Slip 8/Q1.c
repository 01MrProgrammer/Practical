#include<stdio.h>
struct frmnode
{
    int pno,counter;
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
int get_free_lrufno()
{
    int lrufno,fno;
    for(fno=0;fno<n;fno++)
    {
        if(frames[fno].counter < frames[lrufno].counter)
        lrufno=fno;
    }
    return lrufno;
}
void main()
{
    int p_req[]={3, 5, 7, 2, 5, 1, 2, 3, 1, 3, 5, 3, 1, 6, 2};
    int size=sizeof(p_req)/4,currtime;
    printf("%d",size);
    int i,j,page_falts=0,fno;
    printf("\nHow Many Frame:");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        frames[i].pno=-1;
    }
    printf("\npage no  page frame  page falts");
    printf("\n--------------------------------------");
    currtime=0;
    for(i=0;i<size;i++)
    {
        j=page_found(p_req[i]);
        if(j==-1)
        {
            j=get_free_frame();
            if(j==-1)
            j=get_free_lrufno();
            page_falts++;
            frames[j].pno=p_req[i];
            frames[j].counter=currtime;
            printf("\n%4d\t",p_req[i]);
            for(fno=0;fno<n;fno++)
            printf("%4d:%2d",frames[fno].pno,frames[fno].counter);
            printf(" : YES");
        }
        else
        {
            frames[j].counter=currtime;
            printf("\n%4d\t",p_req[i]);
            for(fno=0;fno<n;fno++)
            printf("%4d:%2d",frames[fno].pno,frames[fno].counter);
            printf(" : NO");
        }
        currtime++;
    }
    printf("\nNumber of Page Falts:%d",page_falts);
    printf("\n------------------------------------------");
}