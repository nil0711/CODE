#include<iostream>
using namespace std;
typedef struct employee
{
    int eID;
    char favChar;
    float salary;

}bal;

int main(){
bal harry;
harry.eID=1;
harry.favChar='f';
harry.salary=67.5;
cout<<harry.salary<<endl;
cout<<harry.favChar<<endl;
cout<<harry.eID<<endl;



}