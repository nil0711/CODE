#include<stdio.h>

int main(){
    int a=2, *p;
    p=&a;
    printf("The address of a is %u\n",p);
    printf("The value of a is %d\n",*p);


    return 0;
}