#include<stdio.h>
float power(float n,float p);
int main(){
    float n,p;
    printf("enter number : ");
    scanf("%f",&n);
    printf("\nenter power : ");
    scanf("%f",&p);
    printf("%f to the power %f is %f",n,p,power(n,p));
    return 0;
}
float power(float n,float p){
    float powera;
    if(p==0){return 1;}
    powera = n*power(n,p-1);
    return powera;
}