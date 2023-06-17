#include<stdio.h>
int sum(int n);
int main(){
    int n;
    printf("enter the index of fibonacci term : ");
    scanf("%d",&n);
    printf("The %dth term of fibonacci sequence is %d", n, sum(n));
    return 0;
}
int sum(int n){
    if(n==1){return 1;}
    if(n==2){return 1;}
    int p= sum(n-1)+sum(n-2);
    return p;
}