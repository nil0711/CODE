#include<stdio.h>
void odd_number(int *arr);
int main(){
    int arr[]={653,34,356,4,33,3456,43,4,5453,2};
    odd_number(arr);
    return 0;
}
void odd_number(int *arr){
    int k=0;
    int l=0;
    for (int i = 0; i < 10; i++)
    {
        arr[i]%2==1 ? printf("The number %d in index %d is odd\n",arr[i],i+1)&&k++: printf("The number %d in index %d is even\n",arr[i],i+1)&&l++;
    }
    printf("\nTotal number of odd numbers are %d", k);
    printf("\nTotal number of even numbers are %d\n", l);

    
}