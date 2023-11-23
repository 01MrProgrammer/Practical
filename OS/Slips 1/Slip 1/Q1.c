/*Program for lFu*/
#include <stdio.h>
struct frmnode
{
    int pno, counter, frequency;
} frames[20];
int n;
int page_found(int pno)
{
    int fno;
    for (fno = 0; fno < n; fno++)
    {
        if (frames[fno].pno == pno)
            return fno;
    }
    return -1;
}

int get_free_frame()
{
    int fno;
    for (fno = 0; fno < n; fno++)
    {
        if (frames[fno].pno == -1)
            return (fno);
    }
    return (-1);
}

int get_lfu_Frame()
{
    int lfufno = 0, fno;
    for (fno = 1; fno < n; fno++)
    {
        if (frames[fno].frequency < frames[lfufno].frequency)
            lfufno = fno;
    }
    return lfufno;
}

void main()
{
    int p_request[] = {3, 4, 5, 4, 3, 4, 7, 2, 4, 5, 6, 7, 2, 4, 6};
    int size = sizeof(p_request) / 4, currtime;
    int page_falts = 0, i, j, fno;

    printf("\nHow many frames:");
    scanf("%d", &n);

    // Initialize frames
    for (i = 0; i < n; i++)
    {
        frames[i].pno = -1;
        frames[i].frequency = 0;
    }

    printf("\nPageNo Page Frames Page Fault");
    printf("\n---------------------------------------------------");
    currtime = 0;
    for (i = 0; i < size; i++)
    {
        j = page_found(p_request[i]);
        if (j == -1) // page fault occurs
        {
            j = get_free_frame();
            if (j == -1) // no free frame - do replacement
                j = get_lfu_Frame();
            page_falts++;
            frames[j].pno = p_request[i];
            frames[j].counter = currtime;
            frames[j].frequency++;
            printf("\n%4d\t ", p_request[i]);
            for (fno = 0; fno < n; fno++)
                printf("%4d:%2d", frames[fno].pno, frames[fno].frequency);
            printf(" : YES");
        }
        else // page found
        {
            frames[j].counter = currtime;
            frames[j].frequency++;
            printf("\n%4d\t ", p_request[i]);
            for (fno = 0; fno < n; fno++)
                printf("%4d:%2d", frames[fno].pno, frames[fno].frequency);
            printf(" : NO");
        } // else
        currtime++;
    }     // for
    printf("\n------------------------------------------");
    printf("\n Number of Page_Falts=%d", page_falts);
}
