#include<stdio.h>
void pointer_to_pointer(int **ptr);
int main(){
    int i=4;
    int *ptr,*ptr_1;
    ptr=&i;
    ptr_1=&ptr;
    pointer_to_pointer(ptr_1);
    
    
    return 0;
}
void pointer_to_pointer(int **ptr){
    printf("The value is %d\n",*(*(ptr)));
}