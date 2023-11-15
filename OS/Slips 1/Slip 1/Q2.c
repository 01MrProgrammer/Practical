#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define MAX_INPUT_LENGTH 1024
#define MAX_TOKENS 100

void make_toks(char *s, char *tok[], const char *delimiter) {
    int i = 0;
    char *p;

    p = strtok(s, delimiter);
    while (p != NULL) {
        tok[i++] = p;
        p = strtok(NULL, delimiter);
    }

    tok[i] = NULL;
}

void typeline(char *fn, char *op) {
    int fh, n;
    char c;

    fh = open(fn, O_RDONLY);
    if (fh == -1) {
        printf("File %s not found.\n", fn);
        return;
    }

    if (strcmp(op, "a") == 0) {
        while (read(fh, &c, 1) > 0) {
            printf("%c", c);
        }
        close(fh);
        return;
    }

    n = atoi(op);
    if (n > 0) {
        int i = 0;
        while (read(fh, &c, 1) > 0) {
            printf("%c", c);
            if (c == '\n') {
                i++;
                if (i == n) {
                    break;
                }
            }
        }
    }

    if (n < 0) {
        int i = 0, j = 0;
        while (read(fh, &c, 1) > 0) {
            if (c == '\n') {
                i++;
            }
        }
        lseek(fh, 0, SEEK_SET);
        while (read(fh, &c, 1) > 0) {
            if (c == '\n') {
                j++;
                if (j == i + n) {
                    break;
                }
            }
        }
        while (read(fh, &c, 1) > 0) {
            printf("%c", c);
        }
    }

    close(fh);
}

int main() {
    char input[MAX_INPUT_LENGTH];
    char *tokens[MAX_TOKENS];

    while (1) {
        printf("myshell$ ");
        fflush(stdout);
        if (fgets(input, sizeof(input), stdin) == NULL) {
            perror("Error reading input");
            exit(EXIT_FAILURE);
        }
        input[strcspn(input, "\n")] = '\0';

        make_toks(input, tokens, " ");

        if (tokens[0] == NULL) {
            continue; 
        }

        if (strcmp(tokens[0], "exit") == 0) {
            break;
        }

        if (strcmp(tokens[0], "typeline") == 0 && tokens[1] != NULL && tokens[2] != NULL) {
            typeline(tokens[2], tokens[1]);
        } else {
            pid_t pid = fork();
            if (pid < 0) {
                perror("Fork failed");
                exit(EXIT_FAILURE);
            } else if (pid == 0) {
               
                execvp(tokens[0], tokens);
                perror("Execvp failed");
                exit(EXIT_FAILURE);
            } else {
               
                wait(NULL);
            }
        }
    }

    return 0;
}
