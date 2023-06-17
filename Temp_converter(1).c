#include<stdio.h>

int main(){
    int a;
    float c,f;
    printf("Press 1 for C to F or press 2 for F to C\n");
    scanf("%d",&a);

    if (a==1)
    {
        printf("Enter the value of temperature in Centigrade : ");
        scanf("%f",&c);
        printf("\nThe value of temperature converted to Fahrenheit is %f", 32+(1.8*c));
    }
    if (a==2)
   {
        printf("Enter the value of temperature in Fahrenheit : ");
        scanf("%f",&f);
        printf("\nThe value of temperature converted to Centigrade is %f", (f-32)*5/9);
   }
    else
    {
        printf("The option entered is wrong. Try again");
    }
     return 0;
}