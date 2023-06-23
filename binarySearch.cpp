#include<iostream>
#include<stdio.h>
using namespace std;
int bsearch(int x[],int n,int no)
{
    int l,u,m;
    l=0;
    u=n-1;
    while(l<=u)
     {
         m=(l+u)/2;
         if(x[m]==no)
           return m+1;
         else
           if(x[m]<no)
             l=m+1;
           else 
             u=m-1;    
     }return -1;
}
int main()
{
    int x[10]={1,2,3,4,5,6,7,8,9,10};
    int no;
    cout<<"Enter the index of no you want"<<endl;
    cin>>no;
    int res=bsearch(x,10,no);
    cout<<"Index number is ="<<endl;
    cout<<res;
   return 0; 
}