#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char* alloc_memory(){
    char* str = strdup("Hello World");
    printf("\nmemory allocated\n");
    return str;
}

void free_memory(char* ptr){
    free(ptr);
    printf("Memory dealocated");
}