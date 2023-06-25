#include<stdio.h>
int main(){
    int x=5, *ptr, **pptr;
    ptr = &x;
    pptr=&ptr;
    printf("%d\n",**pptr);
    return 0;
}