#include <stdio.h>
#include <stdlib.h>
#include <time.h>
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
        printf("Enter arrival time for process P%d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
        printf("Enter burst time for process P%d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
        printf("Enter priority for process P%d: ", i + 1);
        scanf("%d", &processes[i].priority);
        processes[i].remaining_time = processes[i].burst_time;
    }
    int time = 2;
    int completed = 0;

    printf("\nGantt Chart:\n");

    while (completed < n) {
        int highest_priority = -1;
        int highest_priority_idx = -1;

        for (int i = 0; i < n; i++) {
            if (processes[i].arrival_time <= time && processes[i].remaining_time > 0) {
                if (highest_priority == -1 || processes[i].priority < highest_priority) {
                    highest_priority = processes[i].priority;
                    highest_priority_idx = i;
                }
            }
        }

        if (highest_priority_idx != -1) {
            struct Process *current_process = &processes[highest_priority_idx];

            printf("P%d ", current_process->id);
            int random_burst = rand() % 10 + 1;
            if (random_burst >= current_process->remaining_time) {
                random_burst = current_process->remaining_time;
            }

            time += random_burst;
            current_process->remaining_time -= random_burst;

            if (current_process->remaining_time == 0) {
                completed++;

                int turnaround_time = time - current_process->arrival_time;
                int waiting_time = turnaround_time - current_process->burst_time;

                printf("(%d) ", time);
                printf("P%d completed\n", current_process->id);

                printf("Turnaround Time for P%d: %d\n", current_process->id, turnaround_time);
                printf("Waiting Time for P%d: %d\n", current_process->id, waiting_time);
            } else {
                printf("(%d) ", time);
                printf("P%d preempted\n", current_process->id);
            }
        } else {
            
            time++;
        }
    }
    int total_turnaround_time = 0;
    int total_waiting_time = 0;
    for (int i = 0; i < n; i++) {
        int turnaround_time = time - processes[i].arrival_time;
        int waiting_time = turnaround_time - processes[i].burst_time;
        total_turnaround_time += turnaround_time;
        total_waiting_time += waiting_time;
    }

    float avg_turnaround_time = (float)total_turnaround_time / n;
    float avg_waiting_time = (float)total_waiting_time / n;

    printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);
    printf("Average Waiting Time: %.2f\n", avg_waiting_time);

    return 0;
}
