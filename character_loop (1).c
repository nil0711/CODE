#include<stdio.h>
void printString(char arr[]);
int main(){
    char first_name[]="Ram";
    char last_name[]="Das";
    printString(first_name);
    printf("\n");
    printString(last_name);
    printf("\n");
    return 0;
}
void printString(char arr[]){
    for(int i=0;arr[i]!='\0';i++){
        printf("%c",arr[i]);
    }
}