#include<iostream>
using namespace std;

int main(){
    int arr[3];

    for(int i=0; i<3; i++){
        cout<<"Enter "<<(i+1)<<"th number "<<endl;
        cin >> arr[i];
    }
    cout<<"The average of the numbers is "<<(float(arr[0]+arr[1]+arr[2])/3)<<endl;
     
}