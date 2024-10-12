#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TASKS 100
#define MAX_TASK_LENGTH 50

struct TaskScheduler {
    char tasks[MAX_TASKS][MAX_TASK_LENGTH];
    int front;
    int rear;
};

struct TaskScheduler* createTaskScheduler() {
    struct TaskScheduler* scheduler = (struct TaskScheduler*)malloc(sizeof(struct TaskScheduler));
    scheduler->front = -1;
    scheduler->rear = -1;
    return scheduler;
}

int isEmpty(struct TaskScheduler* scheduler) {
    return scheduler->front == -1;
}

int isFull(struct TaskScheduler* scheduler) {
    return scheduler->rear == MAX_TASKS - 1;
}

void enqueue(struct TaskScheduler* scheduler, char* task) {
    if (isFull(scheduler)) {
        printf("Scheduler is full\n");
        return;
    }
    if (scheduler->front == -1)
        scheduler->front = 0;
    scheduler->rear++;
    strcpy(scheduler->tasks[scheduler->rear], task);
}

char* dequeue(struct TaskScheduler* scheduler) {
    if (isEmpty(scheduler)) {
        printf("Scheduler is empty\n");
        return NULL;
    }
    char* task = scheduler->tasks[scheduler->front];
    if (scheduler->front == scheduler->rear)
        scheduler->front = scheduler->rear = -1;
    else
        scheduler->front++;
    return task;
}

void display(struct TaskScheduler* scheduler) {
    if (isEmpty(scheduler)) {
        printf("Scheduler is empty\n");
        return;
    }
    printf("Tasks in Scheduler:\n");
    for (int i = scheduler->front; i <= scheduler->rear; i++) {
        printf("%s\n", scheduler->tasks[i]);
    }
}

int main() {
    int choice;
    char task[MAX_TASK_LENGTH];
    struct TaskScheduler* scheduler = createTaskScheduler();

    do {
        printf("\nTask Scheduler Menu\n");
        printf("1. Add Task\n");
        printf("2. Process Task\n");
        printf("3. Display Tasks\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                if (isFull(scheduler)) {
                    printf("Scheduler is full\n");
                } else {
                    printf("Enter the task to add: ");
                    scanf("%s", task);
                    enqueue(scheduler, task);
                }
                break;
            case 2:
                if (isEmpty(scheduler)) {
                    printf("Scheduler is empty\n");
                } else {
                    printf("Processing task: %s\n", dequeue(scheduler));
                }
                break;
            case 3:
                display(scheduler);
                break;
            case 4:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice\n");
        }
    } while (choice != 4);

    return 0;
}
