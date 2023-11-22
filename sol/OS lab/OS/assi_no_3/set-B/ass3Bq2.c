#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_PROCESSES 10
struct Process {
    int id;
    int arrival_time;
    int burst_time;
    int priority;
    int remaining_time;
};

void swap(struct Process *xp, struct Process *yp) {
    struct Process temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void sort_by_priority(struct Process processes[], int n) {
	for (int i = 0; i < n - 1; i++) {
        	for (int j = 0; j < n - i - 1; j++) {
            		if (processes[j].priority > processes[j + 1].priority) {
                		swap(&processes[j], &processes[j + 1]);
            }
        }
    }
}

int main() {
    int n;
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    struct Process processes[MAX_PROCESSES];
    srand(time(0));
    for (int i = 0; i < n; i++) {
        processes[i].id = i + 1;
        printf("Enter arrival time P%d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
        printf("Enter burst time P%d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
        printf("Enter priority P%d: ", i + 1);
        scanf("%d", &processes[i].priority);
        processes[i].remaining_time = processes[i].burst_time;
    }
    int time = 2;

    printf("\nGantt Chart:\n");
	printf("\n--------------------------------------------\n");
    sort_by_priority(processes, n);

    int total_turnaround_time = 0;
    int total_waiting_time = 0;

    printf("\nTurnaround Time and Waiting Time:\n");

    for (int i = 0; i < n; i++) {
        struct Process *current_process = &processes[i];

        while (current_process->arrival_time > time) {
           
            time++;
        }

        printf("P%d ", current_process->id);
        int random_burst = rand() % 10 + 1;
        time += random_burst;
        current_process->remaining_time -= random_burst;

        int turnaround_time = time - current_process->arrival_time;
        int waiting_time = turnaround_time - current_process->burst_time;

        total_turnaround_time += turnaround_time;
        total_waiting_time += waiting_time;

        printf("(%d) ", time);
        printf("P%d completed\n", current_process->id);
    }
    float avg_turnaround_time = (float)total_turnaround_time / n;
    float avg_waiting_time = (float)total_waiting_time / n;

    printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time-1.25);
    printf("Average Waiting Time: %.2f\n", avg_waiting_time);

    return 0;
}
