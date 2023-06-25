#include<stdio.h>
void fibonacci_number_printer(int *arr,int n);
int main(){
    int n;
    printf("Enter n: ");
    scanf("%d",&n);
    int arr[n];
    fibonacci_number_printer(arr,n);


    return 0;
}
void fibonacci_number_printer(int *arr,int n){
    for(int i=0 ; i< n ; i++){
        if(i==0){arr[0]=0;}
        if(i==1){arr[1]=1;}
        arr[i]=arr[i-1]+arr[i-2];
    }
    printf("The first %d fibonacci numbers are : \n",n);
    for(int i=0; i<n ; i++){
        printf("%d\t",arr[i]);
    }
    printf("\n");

}