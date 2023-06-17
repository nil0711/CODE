#include<stdio.h>
float integervalue(float n);
float decimal_value(float n,float p);
void square_root(float n);
void printNO();
int main(){
    float n;
    printf("enter the number : ");
    scanf("%f",&n);
    n>=0 ? square_root(n) : printNO();
    return 0;
}
float integervalue(float n){
    float p; 
    for(int i= 0; i<=n ; i++){
        if(n>=i*i){p=i;}
        else{break;}
    }
    return p;
}
float decimal_value(float n,float p){
    float q;
    for(float i=0.0; i<1.0; i+=0.000001){
        if(n>=(p+i)*(p+i)){q=i;}
        else{break;}
    }
    return q;
}
void square_root(float n){
    float p, s;
    p=integervalue(n);
    s= p + decimal_value(n,p);
    printf("The square root of the number %f is %f", n, s);
}
void printNO(){
    printf("Square root of negative number ille");
}