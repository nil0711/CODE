package com.company;
import java.util.Scanner;
public class java_input {
    public static void main(String[] args) {
        System.out.println("Taking Input from the User");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number 1 :");
        int a= sc.nextInt();
        System.out.println("");
        System.out.print("Enter number 2 :");
        int b= sc.nextInt();
        int sum=a+b;
        System.out.println("");
        System.out.print("The sum is ");
        System.out.println(sum);

    }
}
