#include<stdio.h>
int divide(int n);
int sum(int n);
int main(){
    int n;
    printf("enter the number : ");
    scanf("%d",&n);
    printf("Sum of digits of the number %d is %d", n, sum(n));
    return 0;
}
int divide(int n){
    return (n/10);
}
int sum(int n){
    if(n==0){return 0;}
int p = (n%10)+ sum(divide(n));
return p;
}
