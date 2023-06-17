#include<stdio.h>
int prime(int n);
void printPrime();
void printUnit();
void printComposite();
void printNo();
int main(){
  int n;
  printf("enter number : ");
  scanf("%d",&n);
   int p = prime(n);
   n==0? printNo() : n==1 ? printUnit() : p==0 || n< 0? printComposite() : printPrime();
           return 0;
}
void printNo(){
  printf("The number is neither prime nor composite");
}
void printUnit(){
printf("The number is a unit number");
}
void printComposite(){
printf("The number is a composite number");
}
void printPrime(){
  printf("The number is a prime number");
}
int prime(int n){
  int j=1;
  for(int i=2; i< n; i++ ){
    if(n%i==0){j=0; break;}
  }
  return j;
}