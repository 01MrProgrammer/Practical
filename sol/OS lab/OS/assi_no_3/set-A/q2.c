#include <stdio.h>
#include <stdlib.h>

struct proc_info
{
    int atime;
    int cpub;
} proc[20];

struct rqnode
{
    int pid, cpub;
    struct rqnode *link;
} *first = NULL, *curr, *prev;

struct ganttchart
{
    int stime;
    int pid;
    int etime;
} gchart[20];

int i, n, ctime, gi = 0, wtime[20], ttime[20];

void getprocs();
void start();
void addprocq();
void attachtoq(int);
void addgchart(int);
void dispgchart();
void disptimes();
int getfirstproc();
int finished();

int main()
{
    getprocs();
    ctime = 0;
    start();
    dispgchart();
    disptimes();
    return 0;
}

void getprocs()
{
    printf("How many processes: ");
    scanf("%d", &n);
    printf("PID\tATIME\tBURSTTIME\n");
    for (i = 0; i < n; i++)
    {
        printf("%d\t", i + 1);
        scanf("%d %d", &proc[i].atime, &proc[i].cpub);
    }
}

void start()
{
    int pid;
    addprocq();
    pid = getfirstproc();
    while (!finished())
    {
        if (pid != -1)
        {
            ctime++;
            proc[pid].cpub--;
            if (proc[pid].cpub == 0)
            {
                printf("\nProc %d completed at time %d.", pid + 1, ctime);
                ttime[pid] = ctime - proc[pid].atime;
                pid = getfirstproc();
            }
        }
        else
        {
            ctime++;
        }
        addprocq();
    }
    gchart[gi].etime = ctime;
}

void addprocq()
{
    for (i = 0; i < n; i++)
    {
        if (proc[i].atime == ctime)
        {
            attachtoq(i);
        }
    }
}

void attachtoq(int pid)
{
    struct rqnode *selp, *pselp;
    curr = (struct rqnode *)malloc(sizeof(struct rqnode));
    if (curr == NULL)
    {
        perror("Memory allocation failed");
        exit(EXIT_FAILURE);
    }
    curr->pid = pid;
    curr->cpub = proc[pid].cpub;
    curr->link = NULL;
    if (first == NULL)
    {
        first = curr;
        return;
    }
    selp = first;
    while (selp->cpub <= curr->cpub && selp->link != NULL)
    {
        pselp = selp;
        selp = selp->link;
    }
    if (selp == first)
    {
        curr->link = first;
        first = curr;
    }
    else
    {
        pselp->link = curr;
        curr->link = selp;
    }
}

int finished()
{
    for (i = 0; i < n; i++)
    {
        if (proc[i].cpub != 0)
        {
            return 0;
        }
    }
    return 1;
}

int getfirstproc()
{
    int pid;
    if (first == NULL)
    {
        return -1;
    }
    pid = first->pid;
    curr = first;
    first = first->link;
    free(curr);
    addgchart(pid);
    wtime[pid] = ctime - proc[pid].atime;
    return pid;
}

void addgchart(int pid)
{
    gchart[++gi].pid = pid;
    gchart[gi].stime = ctime;
    gchart[gi - 1].etime = gchart[gi].stime;
}

void dispgchart()
{
    printf("\n");
    for (i = 0; i < gi; i++)
    {
        printf("|---");
    }
    printf("|\n");
    for (i = 0; i < gi; i++)
    {
        printf("| %d ", gchart[i + 1].pid + 1);
    }
    printf("|\n");
    for (i = 0; i < gi; i++)
    {
        printf("|---");
    }
    printf("|\n");
    for (i = 0; i < gi; i++)
    {
        printf("%d ", gchart[i + 1].stime);
    }
    printf("%d\n", gchart[gi].etime);
}

void disptimes()
{
    int sumwt = 0, sumtt = 0;
    printf("\nWaiting Time=");
    printf("\nPID\tWtime");
    for (i = 0; i < n; i++)
    {
        printf("\n%d\t%d", i + 1, wtime[i]);
        sumwt += wtime[i];
    }
    printf("\nAverage WAITING TIME:: %.2f", (float)sumwt / n);

    printf("\nTurnaround Time=");
    printf("\nPID\t ttime");
    for (i = 0; i < n; i++)
    {
        printf("\n%d\t%d", i + 1, ttime[i]);
        sumtt += ttime[i];
    }
    printf("\nAverage TURNAROUND TIME: %.2f", (float)sumtt / n);
}
