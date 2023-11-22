#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int atime;
    int cpub;
    int priority; // Added priority attribute
} proc_info;

typedef struct rqnode {
    int pid, priority;
    struct rqnode *link;
} rqnode;

typedef struct {
    int stime;
    int pid;
    int etime;
} ganttchart;

int n, ctime, gi = 0, wtime[20], ttime[20];
proc_info proc[20];
rqnode *first = NULL;
ganttchart gchart[20];

void getprocs();
void start();
void addprocq();
void attachtoq(int);
int finished();
int gethighestpriorityproc();
void addgchart(int);
void dispgchart();
void disptimes();

int main(void) {
    getprocs();
    ctime = 0;
    start();
    dispgchart();
    disptimes();
    return 0;
}

void getprocs() {
    printf("\nHow many processes: ");
    scanf("%d", &n);
    printf("\nPID\tATIME\tCPUB\tPRIORITY\n");
    for (int i = 1; i <= n; i++) {
        printf("%d\t", i);
        scanf("%d\t%d\t%d", &proc[i].atime, &proc[i].cpub, &proc[i].priority);
    }
}

void start() {
    int pid;
    while (!finished()) {
        addprocq();
        pid = gethighestpriorityproc();
        if (pid != -1) {
            ctime += proc[pid].cpub;  // Increase ctime by burst time for NP
            proc[pid].cpub = 0;
            printf("\nProc %d completed at time %d..", pid, ctime);
            ttime[pid] = ctime - proc[pid].atime;
            addgchart(pid);
        } else {
            ctime++;
        }
    }
}

void addprocq() {
    for (int i = 1; i <= n; i++) {
        if (proc[i].atime == ctime && proc[i].cpub > 0) {
            attachtoq(i);
        }
    }
}

void attachtoq(int pid) {
    rqnode *curr = (rqnode *)malloc(sizeof(rqnode));
    curr->pid = pid;
    curr->priority = proc[pid].priority;
    curr->link = NULL;

    if (!first || first->priority > curr->priority) {
        curr->link = first;
        first = curr;
    } else {
        rqnode *temp = first;
        while (temp->link && temp->link->priority <= curr->priority) {
            temp = temp->link;
        }
        curr->link = temp->link;
        temp->link = curr;
    }
}

int finished() {
    for (int i = 1; i <= n; i++) {
        if (proc[i].cpub != 0) {
            return 0;
        }
    }
    return 1;
}

int gethighestpriorityproc() {
    if (!first) {
        return -1;
    }
    int pid = first->pid;
    rqnode *temp = first;
    first = first->link;
    free(temp);
    wtime[pid] = ctime - proc[pid].atime;
    return pid;
}

void addgchart(int pid) {
    gchart[++gi].pid = pid;
    gchart[gi].stime = ctime - proc[pid].cpub;  // Adjusted for NP
    gchart[gi].etime = ctime;
}

void dispgchart() {
    printf("\n");
    for (int i = 1; i <= gi; i++) {
        printf("|----");
    }
    printf("|\n");
    for (int i = 1; i <= gi; i++) {
        printf("| %d ", gchart[i].pid);
    }
    printf("|\n");
    for (int i = 1; i <= gi; i++) {
        printf("|----");
    }
    printf("|\n");
    for (int i = 1; i <= gi; i++) {
        printf("%d ", gchart[i].stime);
    }
    printf("%d\n", gchart[gi].etime);
}

void disptimes() {
    int sumwt = 0, sumtt = 0;
    printf("\n**Waiting Time**");
    printf("\nPID\tWtime");
    for (int i = 1; i <= n; i++) {
        printf("\n%d\t%d", i, wtime[i]);
        sumwt += wtime[i];
    }
    printf("\nAverage:%.2f\n", (float)sumwt / n);
    printf("\n**Turnaround Time**");
    printf("\nPID\t ttime");
    for (int i = 1; i <= n; i++) {
        printf("\n%d\t%d", i, ttime[i]);
        sumtt += ttime[i];
    }
    printf("\nAverage:%.2f\n", (float)sumtt / n);
}
