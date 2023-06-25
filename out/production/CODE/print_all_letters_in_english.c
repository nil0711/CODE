#include<stdio.h>
void letter_print(char *a);
int main(){
    char $= 'a';
    letter_print(&$);

    return 0;
}
void letter_print(char *a){
    for(char *a = 'a'; *a <= 'z' ; *a++){
        printf("%d \n",*a);
    }
}
