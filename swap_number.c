#include<stdio.h>
int main(){
void swap(int *a,int *b);

    int a=2, b=3;
    swap(&a,&b);
    printf("The value of a and b is %d and %d\n", a, b);
    return 0;
}
void swap(int *a,int *b){
    int t=*a;
    *a=*b;
    *b= t;
    printf("Value of a and b is %d, %d\n", *a, *b);
     
}