#include<stdio.h>
void function(int a, int b, int *sum, int *mul, int*avg);
int main(){
    int a=6,b=4;
    int sum,mul,avg;
    function(a,b,&sum,&mul,&avg);
    printf("sum = %d , mul = %d , avg = %d\n", sum,mul,avg);

}
void function(int a, int b, int *sum, int *mul, int*avg){
    *sum=a+b;
    *mul=a*b;
    *avg=(a+b)/2;

}