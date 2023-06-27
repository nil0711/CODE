#include<stdio.h>
#include<iostream>
using namespace std;
int Sequential(int x[10],int n,int no)
{
    int i;
    for(i=0;i<n;i++)
    {
        if(x[i]==no)
         {
             return i;
         }
    }return -1;
}
int main()
{
    int x[10];
    int n,no;
    int i;
    cout<<"Enter how many numbers you want to"<<endl;
    cin>>n;
    cout<<"Enter the array "<<endl;
    for(i=0;i<n;i++)
    {
        cin>>x[i];
    }
    cout<<"enter the number whose index is needed"<<endl;
    cin>>no;
    int res=Sequential(x,n,no);
    cout<<"The reqired index="<<endl;
    cout<<res;
    return 0;
}