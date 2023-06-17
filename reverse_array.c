#include<stdio.h>
void reverse_array(int *arr);
int main(){
    int arr[]={1,2,3,4,5};
    reverse_array(arr);
    return 0;
}
void reverse_array(int *arr){
    int t;
    for(int i=0; i<2;i++){
        t=*(arr+i);
       *(arr+i)=*(arr+4-i);
        *(arr+4-i)=t;
    }
    for(int i=0; i<5 ; i++){
        printf("%d\t",arr[i]);
    }
    printf("\n");
}