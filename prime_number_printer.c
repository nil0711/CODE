#include<stdio.h>
void primePrinter(int n);
int prime(int n);
int main(){
    int n;
    printf("enter number : ");
  scanf("%d",&n);
  n<=2 ? printf("There are no prime numbers before %d",n): primePrinter(n);
    return 0;
}

void primePrinter(int n){
    printf("The prime numbers before %d are:\n",n);
    for(int i=2; i< n;i++){
    int p=prime(i);
    if(p==0){continue;}
    else{printf("%d\n",i);}
    }
}
int prime(int n){
  int j=1;
  for(int i=2; i< n; i++ ){
    if(n%i==0){j=0; break;}
  }
  return j;
}