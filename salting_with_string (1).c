#include<stdio.h>
#include<string.h>
void salting(char password[]);
int main(){
    char password[100];
    scanf("%s",password);
    return 0;
}
void salting(char password[]){
    char salt[]="12tfh3";
    char newPass[200];

    strcpy(newPass, password);
    strcat(newPass, salt);
    puts(newPass);

}