#include <stdio.h>

struct Frame {
    int content;
    int status; // 0: empty, 1: occupied
    int reference_count; // Used for LRU
    int future_occurrence; // Used for Optimal
};

void fifo(int pages[], int num_pages, int num_frames);
void lru(int pages[], int num_pages, int num_frames);
void optimal(int pages[], int num_pages, int num_frames);

void main() {
    int num_pages, num_frames;
    int pages[100];

    printf("Enter the number of pages: ");
    scanf("%d", &num_pages);
    
    for (int i = 0; i < num_pages; i++) {
        printf("Enter page number %d: ", i + 1);
        scanf("%d", &pages[i]);
    }
    
    printf("Enter the number of frames: ");
    scanf("%d", &num_frames);

    fifo(pages, num_pages, num_frames);
    lru(pages, num_pages, num_frames);
    optimal(pages, num_pages, num_frames);
}

void fifo(int pages[], int num_pages, int num_frames) {
    struct Frame frames[num_frames];
    int i, j, cnt = 0, found, id = 0;

    for (i = 0; i < num_frames; i++) {
        frames[i].content = -1;
        frames[i].status = 0;
    }

    printf("\nFIFO Page Replacement\n");
    printf("\tREFERENCE STRING\t STATUS\t\tFRAME CONTENT\n");

    for (i = 0; i < num_pages; i++) {
        found = 0;
        printf("\t\t%d\t\t", pages[i]);
        
        for (j = 0; j < num_frames; j++) {
            if (frames[j].content == pages[i]) {
                found = 1;
                break;
            }
        }

        printf("%s\t\t", found ? "HIT" : "MISS");

        if (found == 0) {
            if (frames[id % num_frames].status == 1) {
                cnt++;
            }
            frames[id % num_frames].content = pages[i];
            frames[id % num_frames].status = 1;
            id++;
        }
        
        for (j = 0; j < num_frames; j++) {
            if (frames[j].status != 0) {
                printf("%d   ", frames[j].content);
            }
        }
        printf("\n");
    }

    printf("\nPAGE FAULTS: %d\n", cnt);
}

void lru(int pages[], int num_pages, int num_frames) {
    struct Frame frames[num_frames];
    int i, j, k, cnt = 1, page_faults = 0, id = 0, min;

    for (i = 0; i < num_frames; i++) {
        frames[i].content = -1;
        frames[i].reference_count = 0;
    }

    printf("\nLRU Page Replacement\n");
    printf("\nREFERENCING PAGE\tSTATUS\t\tFRAME CONTENT\n\n");

    for (i = 0; i < num_pages; i++) {
        printf("\t%d\t\t", pages[i]);

        for (j = 0; j < num_frames; j++) {
            if (frames[j].content == pages[i]) {
                printf("HIT\t\t");
                frames[j].reference_count = cnt++;
                break;
            }
        }

        if (j == num_frames) {
            printf("MISS\t\t");

            if (id < num_frames) {
                frames[id].content = pages[i];
                frames[id].reference_count = cnt++;
                id++;
            } else {
                min = 0;
                for (k = 0; k < num_frames; k++) {
                    if (frames[k].reference_count < frames[min].reference_count) {
                        min = k;
                    }
                }
                frames[min].content = pages[i];
                frames[min].reference_count = cnt++;
            }
            page_faults++;
        }

        for (j = 0; j < num_frames; j++) {
            if (frames[j].content != -1) {
                printf("%d\t", frames[j].content);
            }
        }
        printf("\n");
    }

    printf("\nPAGE FAULTS: %d\n", page_faults);
}

void optimal(int pages[], int num_pages, int num_frames) {
    struct Frame frames[num_frames];
    int i, j, k, page_faults = 0, id = 0;

    for (i = 0; i < num_frames; i++) {
        frames[i].content = -1;
        frames[i].future_occurrence = -1;
    }

    printf("\nOptimal Page Replacement\n");
    printf("\nREFERENCING PAGE\tSTATUS\t\tFRAME CONTENT\n\n");

    for (i = 0; i < num_pages; i++) {
        printf("\t%d\t\t", pages[i]);

        int found = 0;
        for (j = 0; j < num_frames; j++) {
            if (frames[j].content == pages[i]) {
                printf("HIT\t\t");
                found = 1;
                break;
            }
        }

        if (!found) {
            printf("MISS\t\t");

            if (id < num_frames) {
                frames[id].content = pages[i];
                frames[id].future_occurrence = 0;
                id++;
            } else {
                int max_future_occurrence = 0;
                int replace_index = 0;

                for (j = 0; j < num_frames; j++) {
                    int future_occurrence = -1;

                    for (k = i + 1; k < num_pages; k++) {
                        if (frames[j].content == pages[k]) {
                            future_occurrence = k;
                            break;
                        }
                    }

                    if (future_occurrence == -1) {
                        replace_index = j;
                        break;
                    } else if (future_occurrence > max_future_occurrence) {
                        max_future_occurrence = future_occurrence;
                        replace_index = j;
                    }
                }

                frames[replace_index].content = pages[i];
                frames[replace_index].future_occurrence = max_future_occurrence;
            }
            page_faults++;
        }

        for (j = 0; j < num_frames; j++) {
            if (frames[j].content != -1) {
                printf("%d\t", frames[j].content);
            }
        }
        printf("\n");
    }

    printf("\nPAGE FAULTS: %d\n", page_faults);
}