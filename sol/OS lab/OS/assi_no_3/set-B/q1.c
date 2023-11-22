#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <limits.h>

struct Process {
    int id;             
    int arrival_time;   
    int burst_time;     
    int remaining_time; 
    int turnaround_time; 
    int waiting_time;    
};

void calculateTimes(struct Process *processes, int n) 
{
    int current_time = 0;
    int completed = 0;
    while (completed < n) 
    {
        int shortest = -1;
        int shortest_time = INT_MAX;
        for (int i = 0; i < n; i++) 
        {
            if (processes[i].arrival_time <= current_time && processes[i].remaining_time < shortest_time && processes[i].remaining_time > 0) 
            {
                shortest = i;
                shortest_time = processes[i].remaining_time;
            }
        }

        if (shortest == -1) 
        {
            current_time++;
        } 
        else 
        {
            processes[shortest].remaining_time--;
            if (processes[shortest].remaining_time == 0) 
            {
                completed++;
                int finish_time = current_time + 1;
                processes[shortest].turnaround_time = finish_time - processes[shortest].arrival_time;
                processes[shortest].waiting_time = processes[shortest].turnaround_time - processes[shortest].burst_time;
            }
            current_time++;
        }
    }
}

int main() 
{
    int n;
    printf("Enter the number of processes: ");
    scanf("%d", &n);
    struct Process *processes = (struct Process *)malloc(n * sizeof(struct Process));
    srand(time(NULL));
    for (int i = 0; i < n; i++) 
    {
        processes[i].id = i + 1;
        printf("Enter arrival time P%d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
        printf("Enter initial CPU burst P%d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
        processes[i].remaining_time = processes[i].burst_time;
    }

    calculateTimes(processes, n);
    float avg_waiting_time = 0, avg_turnaround_time = 0;
    for (int i = 0; i < n; i++) 
    {
        avg_waiting_time += processes[i].waiting_time;
        avg_turnaround_time += processes[i].turnaround_time;
    }
    avg_waiting_time /= n;
    avg_turnaround_time /= n;
    printf("\nGantt Chart:\n");
    int current_time = 0;
    while (1) 
    {
        int shortest = -1;
        int shortest_time = INT_MAX;
        for (int i = 0; i < n; i++) 
        {
            if (processes[i].arrival_time <= current_time && processes[i].remaining_time < shortest_time && processes[i].remaining_time > 0) 
            {
                shortest = i;
                shortest_time = processes[i].remaining_time;
            }
        }
        if (shortest == -1) 
        {
            printf("-");
            current_time++;
        } 
        else 
        {
            printf("P%d", processes[shortest].id);
            processes[shortest].remaining_time--;
            current_time++;
        }
        if (current_time >= 100)
            break;
    }
    printf("\n\nTurnaround Time:\n");
    for (int i = 0; i < n; i++) 
    {
        printf("Process P%d: %d\n", processes[i].id, processes[i].turnaround_time);
    }
    printf("\nWaiting Time:\n");
    for (int i = 0; i < n; i++) 
    {
        printf("Process P%d: %d\n", processes[i].id, processes[i].waiting_time);
    }
    printf("\nAverage Waiting Time: %.2f\n", avg_waiting_time);
    printf("Average Turnaround Time: %.2f\n", avg_turnaround_time);
    free(processes);
    return 0;
}

