# include<stdio.h>

int main(){
    int r,h;
    float pi = 3.14;
    printf("This is a calculator which determines the volume of a Cylinder\n");
    printf("Enter radius : ");
    scanf("%d",&r);
    printf("Enter height : ");
    scanf("%d",&h);
    printf("\nThe volume of the Cylinder is %f", r*r*h*pi);
    return 0;
// 
}