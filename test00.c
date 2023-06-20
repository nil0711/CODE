#include<stdio.h>
# define sqr(a) a*a 
void main(){
    int i =0,k=-3;
    for(i=0;i<5;i++){
        switch (i+k)
        {
        case 1:
        case 2: printf("*");
        case 3: printf("*");
        
           
        
        default: printf("*");
           
        }
    }
    
}