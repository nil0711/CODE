#include<stdio.h>
#include<math.h>
// void bal(float n){
//     if(pow(n,0.5))
// }
int main(){
    float n=10;
    int j=0;
    while (1)
    {
        n=sqrt(n);
        j++;
        if(n==1){break;}
    }
    printf("%d",j);
    
    
    return 0;
}