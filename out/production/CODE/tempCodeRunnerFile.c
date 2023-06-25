#include<stdio.h>
void marks_store(int n, int m,int marks[n][m]);
int main(){
    int n,m;
    printf("\nEnter the number of student : ");
    scanf("%d",&n);
    printf("\nEnter the number of subjects : ");
    scanf("%d",&m);
    
    int marks[n][m];
    marks_store(n,m,marks[n][m]);
    
    return 0;
}
void marks_store(int n, int m,int marks[n][m]){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            printf("\nEnter the marks of student %d in %d : ",i+1,j+1);
            scanf("%u",marks[