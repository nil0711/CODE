#include<stdio.h>
void sum(float *a,float *b);
void avg(float *a,float *b);
float main(){
    float a=2,b=3;
    float *ptr_a,*ptr_b;
    ptr_a=&a;
    ptr_b=&b;
    sum(ptr_a,ptr_b);
    avg(ptr_a,ptr_b);
    return 0;
}
void sum(float *a,float *b){
    printf("The sum of the numbers is %f\n",(*a)+(*b));
}
void avg(float *a,float *b){
    printf("The avg of the numbers is %f\n",((*a)+(*b))/2);
}