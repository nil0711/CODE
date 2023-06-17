#include<stdio.h>
    
int main(){
    int marks[2][3];
    for(int i=0 ; i<2 ;i++){
        for(int j=0; j<3; j++){
            printf("Enter value for marks[%d][%d]:", i, j);
            scanf("%d",&marks[i][j]);
        }

    }
    return 0;
}

