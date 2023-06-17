#include<stdio.h>

int main(){
    int id[5];
    int *ptr=&id[0];
    for(int i =0; i<5;i++){
        printf("%d index : \n",i);
        scanf("%d",(ptr+i));
    }
    for(int i= 0; i<5;i++){
        printf("%d\n",id[i]);
    }

    return 0;
}