#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

// Function to perform binary search on a sorted array
int binarySearch(int arr[], int size, int target) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // Target not found
}

int main() {
    int arr[] = {12, 34, 55, 64, 72, 91, 108};
    int size = sizeof(arr) / sizeof(arr[0]);
    int target = 55;

    pid_t pid = fork();

    if (pid == 0) {
        // Child process
        char *binarySearchProgram = "./binary_search"; // Assuming you have a binary_search program
        char size_str[10];
        sprintf(size_str, "%d", size);
        char target_str[10];
        sprintf(target_str, "%d", target);

        char *args[] = {binarySearchProgram, size_str, target_str, NULL};
        execve(binarySearchProgram, args, NULL);
        perror("execve"); // This line will execute only if execve fails
        exit(EXIT_FAILURE);
    } else if (pid > 0) {
        // Parent process
        wait(NULL); // Wait for the child to finish

        // Sort the array
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        printf("Sorted Array: ");
        for (int i = 0; i < size; i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
    } else {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    return 0;
}
