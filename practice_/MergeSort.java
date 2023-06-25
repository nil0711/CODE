package practice_;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    private static void mergeSort(int[] arr){
        int arrLength= arr.length;
        if (arrLength<2)return;
        int midArr= arrLength/2;
        int[] leftHalf=new int[midArr];
        int[] rightHalf=new int[arrLength-midArr];
        for (int i = 0; i<midArr;i++){
            leftHalf[i]=arr[i];
        }
        for (int i = midArr; i<arrLength;i++){
            rightHalf[i-midArr]=arr[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);

//        Merge
        Merge(arr,leftHalf,rightHalf);

    }
    private static void Merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize= leftHalf.length;
        int rightSize=rightHalf.length;
        int i= 0, j= 0, k= 0;

        while (i<leftSize && j< rightSize){
            if (leftHalf[i]<=rightHalf[j]){
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
            j++;k++;
        }

    }
    private static void printArray(int[] arr){
        int count = 0;
        for (int element:arr) {
            System.out.print(element+"\t");
            count++;
            if(count%10==0) System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] arr = new int[50];
        for (int i=0; i< arr.length;i++){
            arr[i]=rand.nextInt(1000,1040);
        }
        System.out.println("Before Merge Sort");
        printArray(arr);
        System.out.println("Do you want to do merge sort ? y/n...");
        String choice=sc.next();
        if (Objects.equals(choice, "n"))System.exit(0);
        System.out.println("After Merge Sort");
        mergeSort(arr);
        printArray(arr);
    }
}
