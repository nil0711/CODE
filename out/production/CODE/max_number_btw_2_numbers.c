#include<stdio.h>
void function(int *a,int *b);
int main(){
    int a =647 , b= 7587;
    function(&a,&b);

    return 0;
}
void function(int *a,int *b){
    printf("%d , %d\n",*a,*b);
    *a > *b ? printf("a is greater than b\n"): printf("b is greater than a\n");
}