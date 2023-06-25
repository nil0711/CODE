#include<stdio.h>

int main(){
    int price[3];
    for(int i=0; i<= 2; i++){
        printf("Enter price of item %d : \n", i);
        scanf("%d",&price[i]);
    }
    for(int i=0; i<= 2; i++){
        printf("final cost of item %d is %f\n",i,1.18*price[i]);
    }
    return 0;
}