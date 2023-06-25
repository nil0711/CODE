package practice_;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class quick_sort {
    private static void sort(int[] arr, int  lowIndex, int highIndex){
        if(lowIndex>=highIndex)return;
        int pivot=arr[highIndex];
        int leftPointer= lowIndex;
        int rightPointer= highIndex;
        while (leftPointer<rightPointer){
            while (arr[leftPointer]<=pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while (arr[rightPointer]>=pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer,highIndex);
        sort(arr,lowIndex,leftPointer-1);
        sort(arr,leftPointer+1,highIndex);
    }
    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]= temp;
    }
    private static void print(int[] arr){
        int count = 0;
        for (int element:arr) {
            System.out.print(element+"\t");
            count++;
            if(count%10==0) System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] arr = new int[50];
        for (int i = 0; i<arr.length;i++){
            arr[i]=random.nextInt(1000,10000);
        }
        System.out.println("Array is :");
        print(arr);

        System.out.println("Do you want to quick sort ?....y/n");
        String choice = sc.next();
        if(Objects.equals(choice,"n"))System.exit(0);
        System.out.println("After quick sort :");
        sort(arr,0,arr.length-1);
        print(arr);



    }
}
