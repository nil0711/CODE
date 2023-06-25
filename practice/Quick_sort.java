package practice;

import java.util.*;

public class Quick_sort {
    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex>=highIndex)return;
        int pivot = arr[highIndex];
        int leftPointer=lowIndex;
        int rightPointer=highIndex;
        while (leftPointer<rightPointer){
            while (arr[leftPointer]<=pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while (arr[rightPointer]>=pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            swap(arr, leftPointer,rightPointer);
        }
        swap(arr,leftPointer,highIndex);
         quickSort(arr,lowIndex,leftPointer-1);
        quickSort(arr,leftPointer+1,highIndex);

    }
    private static void swap(int[]arr, int index1, int index2){
       int temp = arr[index1];
       arr[index1]=arr[index2];
       arr[index2]=temp;
    }

    private static void printArray(int[] arr){
        for (int element: arr){
            System.out.print(element+"\t");
        }
        System.out.println();
    }
    private static void insertion(int[] arr){
        for (int i=1; i<arr.length;i++){
            int temp=arr[i];
            int j = i-1;
            while (j>=0&&arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    public static int[] countSort(int[] arr) {
        if (arr.length == 0) return arr;

        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = countMap.getOrDefault(arr[i], 0);
            countMap.put(arr[i], count + 1);
        }
        System.out.println(countMap);

        int[] sortedArr = new int[arr.length];
        int index = 0;
        for (int i = min; i <= max; i++) {
            if (countMap.containsKey(i)) {
                int count = countMap.get(i);
                for (int j = 0; j < count; j++) {
                    sortedArr[index] = i;
                    index++;
                }
            }
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i< arr.length;i++){
            arr[i]= rand.nextInt(1000,1040);
        }
        System.out.println("Before sorting the array is :");
        printArray(arr);
        System.out.println("Do you want to do quick sort?....y/n");
        String choice = sc.next();
        if (Objects.equals(choice, "n"))System.exit(0);
        System.out.println("After quick sort the array is :");
//        quickSort(arr,0, arr.length-1);
//        printArray(arr);
//        boolean swap = true;
//        while (swap) {
//            swap=false;
//            for (int i = 0; i < arr.length - 1; i++) {
//                if ((arr[i]) > (arr[i + 1])) {
//                    swap=true;
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//
//
//                }
//            }
//        }

//        insertion(arr);
        arr=countSort(arr);
        printArray(arr);

    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i<arr.length-1;i++){
            int min = i;
            for (int j=i+1; j<arr.length-1;j++){
                if (arr[j]<=arr[min]) min=j;
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }

    }
}
