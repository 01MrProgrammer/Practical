#include<stdio.h>

struct frmnode
{
    int pno;
} frames[20];

int n;
int page_found(int pno)
{
    int fno;
    for(fno = 0; fno < n; fno++)
    {
        if(frames[fno].pno == pno)
            return fno;
    }
    return -1;
}

int get_free_frame()
{
    int fno;
    for (fno = 0; fno < n; fno++)
    {
        if (frames[fno].pno == -1) // free
            return(fno);
    }
    return(-1);
}

int get_optimal_frame(int start_index, int size, int pages[])
{
    int i, j, max_index = -1, max_distance = -1;

    for (i = 0; i < n; i++)
    {
        int distance = 0;

        for (j = start_index; j < size; j++)
        {
            if (frames[i].pno == pages[j])
            {
                distance = j - start_index;
                break;
            }
        }

        if (distance == 0)
            return i; // If the page will not be used again, return this frame

        if (distance > max_distance)
        {
            max_distance = distance;
            max_index = i;
        }
    }

    return max_index;
}

int main()
{
    int p_request[] = {8, 5, 7, 8, 5, 7, 2, 3, 7, 3, 5, 9, 4, 6, 2};
    int size = sizeof(p_request) / sizeof(int);
    printf("%d", size);
    int page_faults = 0, i, j, fno;

    printf("\nHow many frames:");
    scanf("%d", &n);

    // Initialize frames
    for (i = 0; i < n; i++)
    {
        frames[i].pno = -1;
    }

    printf("\nPageNo Page Frames Page Fault");
    printf("\n---------------------------------------------------");

    for (i = 0; i < size; i++)
    {
        j = page_found(p_request[i]); // return frame number
        if (j == -1) // page fault occurs
        {
            page_faults++;
            j = get_free_frame();
            if (j == -1) // no free frame - do page replacement
                j = get_optimal_frame(i + 1, size, p_request);

            frames[j].pno = p_request[i]; // load page into frame
            printf("\n%4d\t ", p_request[i]);
            for (fno = 0; fno < n; fno++)
                printf("%4d", frames[fno].pno);
            printf(" : YES");
        }
        else // page found in frame j
        {
            printf("\n%4d\t ", p_request[i]);
            for (fno = 0; fno < n; fno++)
                printf("%4d", frames[fno].pno);
            printf(" : NO");
        }
    }

    printf("\n-------------------------------------------------------");
    printf("\n Number of Page Faults = %d\n", page_faults);

    return 0;
}
