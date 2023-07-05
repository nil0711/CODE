#include<stdio.h>
#include<string.h>
struct employee{
int code;
float salary;
char name[10];
};
int main(){
    struct employee e1;
    e1.salary=67.9;
    e1.code=2;
    strcpy(e1.name,"Dino");
    return 0;
}