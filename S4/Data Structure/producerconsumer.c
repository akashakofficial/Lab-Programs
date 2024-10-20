#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

#define BUFFER_SIZE 10

int buffer[BUFFER_SIZE];
int in = 0, out = 0;

sem_t empty, full, mutex;

void *producer(void *arg) {
    int item;
    for (int i = 0; i < 10; i++) {
        item = rand() % 10;
        
        sem_wait(&empty);
        sem_wait(&mutex);
        
        buffer[in] = item;
        printf("Producer produced item: %d\n", item);
        in = (in + 1) % BUFFER_SIZE;
        
        sem_post(&mutex);
        sem_post(&full);
        
        sleep(1);
    }
    pthread_exit(NULL);
}

void *consumer(void *arg) {
    int item;
    for (int i = 0; i < 10; i++) {
        sem_wait(&full);
        sem_wait(&mutex);
        
        item = buffer[out];
        printf("Consumer consumed item: %d\n", item);
        out = (out + 1) % BUFFER_SIZE;
        
        sem_post(&mutex);
        sem_post(&empty);
        
        sleep(1);
    }
    pthread_exit(NULL);
}

int main() {
    pthread_t prod_thread, cons_thread;
    
    sem_init(&empty, 0, BUFFER_SIZE);
    sem_init(&full, 0, 0);
    sem_init(&mutex, 0, 1);
    
    pthread_create(&prod_thread, NULL, producer, NULL);
    pthread_create(&cons_thread, NULL, consumer, NULL);
    
    pthread_join(prod_thread, NULL);
    pthread_join(cons_thread, NULL);
    
    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&mutex);
    
    return 0;
}