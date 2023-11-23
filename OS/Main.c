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

/*int get_fifo_frame()
{
    static int fno=-1;
    fno=(fno+1)%n;
    return fno;
}*/

int get_opt_frame(int start_index,int size,int pages[])
{
    int i,j,max_index=-1,max_distance=-1;
    for(i=0;i<n;i++)
    {
        int distance=0;
        for(j=start_index;j<size;j++)
        {
            if(frames[i].pno==pages[j])
            {
                distance = j-start_index;
                break;
            }
        }
        if(distance==0)
        return i;
        if(distance>max_distance)
        {
            max_distance=distance;
            max_index=i;
        }
    }
    return max_index;
}

main()
{
    int p_req[]={8, 5, 7, 8, 5, 7, 2, 3, 7, 3, 5, 9, 4, 6, 2};
    int size=sizeof(p_req)/sizeof(int);
    printf("%d",size);
    int page_falts=0,i,j,fno;
    printf("\nHow Many Frames:");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        frames[i].pno=-1;
    }
    printf("\nPage Number  Page Frame  Page falts");
    printf("\n----------------------------------------------");
    for(i=0;i<size;i++)
    {
        j=page_found(p_req[i]);
        if(j==-1)
        {
            page_falts++;
            j=get_free_frame();
            if(j==-1)
            j=get_opt_frame(i+1,size,p_req);
            frames[j].pno=p_req[i];
            printf("\n%4d\t",p_req[i]);
            for(fno=0;fno<n;fno++)
            printf("%4d",frames[fno].pno);
            printf(" :YES");
        }
        else
        {
            printf("\n%4d\t",p_req[i]);
            for(fno=0;fno<n;fno++)
            printf("%4d",frames[fno].pno);
            printf(" :NO");
        }
    }
    printf("\nNumber of Page Falts:%d",page_falts);
    printf("\n---------------------------------------------");
}