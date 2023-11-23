/*Program for FIFO Page replacement simulation*/
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
    for (fno=0; fno<n; fno++)
    {
        if (frames[fno].pno==-1)//free
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
main()
{
    int p_request[]={3, 4, 5, 6, 3, 4, 7, 3, 4, 5, 6, 7, 2, 4, 6};
    int size=sizeof(p_request)/sizeof(int);//number of requests
    printf("%d",size);
    int page_falts=0,i,j,fno;
    //clrscr();
    printf("\nHow many frames:"); 
    scanf("%d",&n);
    //initialize frames
    for (i=0; i<n; i++)
    { 
        frames[i].pno=-1;
    }
    printf("\nPageNo Page Frames Page Fault");
    printf("\n---------------------------------------------------");
    for(i=0;i<size;i++)
    {
        j=page_found(p_request[i]);//return frame number
        if(j==-1) //page fault occurs
        {
            page_falts++;
            j=get_free_frame();
            if (j==-1) //no free frame - do page replacement
            j=get_fifo_frame();
            frames[j].pno=p_request[i];//load page in frame
            printf("\n%4d\t ",p_request[i]);
            for (fno=0; fno<n; fno++)
            printf("%4d",frames[fno].pno);
            printf(" : YES");
        }			
        else //page found in frame j
        {
            printf("\n%4d\t ",p_request[i]);
            for (fno=0; fno<n; fno++)
            printf("%4d",frames[fno].pno);
            printf(" : NO");
        }  
    }//for
    printf("\n-------------------------------------------------------");
    printf("\n Number of Page_Falts=%d",page_falts);
    //getch();
}


/*

[?2004l
16
How many frames:3

PageNo Page Frames Page Fault
---------------------------------------------------
  12	   12  -1  -1 : YES
  15	   12  15  -1 : YES
  12	   12  15  -1 : NO
  18	   12  15  18 : YES
   6	    6  15  18 : YES
   8	    6   8  18 : YES
  11	    6   8  11 : YES
  12	   12   8  11 : YES
  19	   12  19  11 : YES
  12	   12  19  11 : NO
   6	   12  19   6 : YES
   8	    8  19   6 : YES
  12	    8  12   6 : YES
  15	    8  12  15 : YES
  19	   19  12  15 : YES
   8	   19   8  15 : YES
-------------------------------------------------------
 Number of Page_Falts=14[?2004h



[?2004l
16
How many frames:3

PageNo Page Frames Page Fault
---------------------------------------------------
  12	   12  -1  -1 : YES
  15	   12  15  -1 : YES
  12	   12  15  -1 : NO
  18	   12  15  18 : YES
   6	   6  15  18 : YES
   8	    	6   8  18 : YES
  11	    6   8  11 : YES
  12	   12   8  11 : YES
  19	   12  19  11 : YES
  12	   12  19  11 : NO
   6	   12  19   6 : YES
   8	    8  19   6 : YES
  12	    8  12   6 : YES
  15	    8  12  15 : YES
  19	   19  12  15 : YES
   8	   19   8  15 : YES
-------------------------------------------------------
 Number of Page_Falts=14

*/