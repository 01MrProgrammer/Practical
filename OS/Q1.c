#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

#define MAX_INPUT_SIZE 1024

void execute_command(char *command) {
    pid_t pid;
    int status;

    pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Child process
        char *args[MAX_INPUT_SIZE];
        int i = 0;

        // Tokenize the command
        char *token = strtok(command, " \t\n");

        while (token != NULL) {
            args[i++] = token;
            token = strtok(NULL, " \t\n");
        }

        args[i] = NULL; // Null-terminate the argument list

        // Execute the command
        if (execvp(args[0], args) == -1) {
            perror("Error executing command");
            exit(EXIT_FAILURE);
        }
    } else {
        // Parent process
        waitpid(pid, &status, 0);

        if (WIFEXITED(status)) {
            printf("Child process exited with status %d\n", WEXITSTATUS(status));
        }
    }
}

int main() {
    char input[MAX_INPUT_SIZE];

    while (1) {
        // Display the command prompt
        printf("myshell$ ");
        fflush(stdout);

        // Read the input
        if (fgets(input, sizeof(input), stdin) == NULL) {
            perror("Error reading input");
            exit(EXIT_FAILURE);
        }

        // Remove the newline character
        input[strcspn(input, "\n")] = '\0';

        // Exit the shell if the user enters 'exit'
        if (strcmp(input, "exit") == 0) {
            break;
        }

        // Execute the command
        execute_command(input);
    }

    return 0;
}