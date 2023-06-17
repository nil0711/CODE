#include<stdio.h>

int main(){
    int n;
    printf("enter Temperature : ");
    scanf("%d",&n);
    n>25? printf("is hot") : printf("is cool");
    return 0;
}