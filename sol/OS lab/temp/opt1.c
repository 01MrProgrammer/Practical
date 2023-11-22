#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_FRAMES 100

void opt(int reference_string[], int n, int frames);

int main() {
    int reference_string[] = {7,2,8,4,5,8,4,7,6,1,3,7};
    int n;
    
    printf("Enter the number of memory frames: ");
    scanf("%d", &n);

    printf("\nUsing OPT:\n");
    opt(reference_string, sizeof(reference_string) / sizeof(reference_string[0]), n);

    
    return 0;
}

void opt(int reference_string[], int n, int frames) {
    int memory[MAX_FRAMES];
    int page_faults = 0;
    int next_use[MAX_FRAMES];
    int i, j;
    
    for (i = 0; i < frames; i++) {
        memory[i] = -1;
        next_use[i] = 0;
    }
    
    for (i = 0; i < n; i++) {
        int page = reference_string[i];
        bool page_found = false;
        
        for (j = 0; j < frames; j++) {
            if (memory[j] == page) {
                page_found = true;
                break;
            }
        }
        
        if (!page_found) {
            int replace_index = -1;
            for (j = 0; j < frames; j++) {
                if (memory[j] == -1) {
                    replace_index = j;
                    break;
                }
                
                if (next_use[j] > next_use[replace_index]) {
                    replace_index = j;
                }
            }
            
            memory[replace_index] = page;
            page_faults++;
        }
        
        for (j = 0; j < frames; j++) {
            next_use[j]++;
            if (memory[j] == page) {
                next_use[j] = 0;
            }
        }
        
        printf("Page %d: [", page);
        for (j = 0; j < frames; j++) {
            printf("%d", memory[j]);
            if (j < frames - 1) {
                printf(", ");
            }
        }
        printf("]\n");
    }
    
    printf("Total page faults (OPT): %d\n", page_faults);
}


