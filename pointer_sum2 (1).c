#include<stdio.h>
void print(int *ptr);
int main(){
    int i;
    int *ptr;
    ptr=&i;
    printf("The address of %d is %u\n",i,ptr);
    print(ptr);
    return 0;
}
void print(int *ptr){
    printf("The address of i is %u\n",ptr);
}