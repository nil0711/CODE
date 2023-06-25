#include<stdio.h>

int main(){
    int arr[]={28,6,3,0,6,3,4,7,5,3,54,4,4,5,6,5,44,7};
    int k=arr[0];
    for(int i=0;i<18;i++){
        if(k<arr[i]){
            k=arr[i];
        }
        else{continue;}

    }
    printf("\nThe largest number of the array is %d\n",k);

    return 0;
}