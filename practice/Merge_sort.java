package practice;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Merge_sort {
    private  static void mergeSort(int[] arr){
        int arrLength= arr.length;
        if (arrLength<2)return;
        int arrMid = arrLength/2;
        int[] leftHalf= new int[arrMid];
        int[] rightHalf = new int[arrLength-arrMid];
        for (int i =0; i<arrMid;i++)leftHalf[i]=arr[i];
        for (int i = arrMid; i<arrLength;i++)rightHalf[i-arrMid]=arr[i];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

//      Merging the divided array
        merge(arr,leftHalf,rightHalf);
    }
    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0 , k=0;
        while (i<leftSize && j<rightSize){
            if(leftHalf[i]<=rightHalf[j]) {
                arr[k]=leftHalf[i];
                i++;
            }
            else {
                arr[k]=rightHalf[j];
                j++;
            }
            k++;
        }
        while (i<leftSize){
            arr[k]=leftHalf[i];
            i++;k++;
        }
        while (j<rightSize){
            arr[k]=rightHalf[j];
            k++;j++;
        }

    }
    private static void printArray(int[] arr){
        System.out.println("The array is : ");
        for (int element:arr) {
            System.out.println(element);

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] arr = new int[1000000];
        for (int i=0;i<arr.length;i++){
            arr[i]= rand.nextInt(10000000);
        }
//        Printing the array before performing the merge sort
        printArray(arr);
        System.out.println("Do you want to do merge sort ? y/n......");
        String choice=sc.next();
        if(Objects.equals(choice, "n"))System.exit(0);
//        After doing merge sort
        mergeSort(arr);

        System.out.print("After Merge sort ");printArray(arr);

    }
}
