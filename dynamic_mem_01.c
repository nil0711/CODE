#include<stdio.h>
#include<stdlib.h>

int main(){
    int *ptr;
    ptr=(int*) malloc(5*sizeof(int));
    for(int i=0;i<5;i++){
        printf("ENter the value of %d element \n",i);
        scanf("%d",&ptr[i]);
    }
    for(int i=0;i<5;i++){
        printf("ENter the value of %d element \n",i);
        scanf("%d",&ptr[i]);
    }
    return 0;
}