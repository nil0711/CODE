import java.util.*;

public class binary_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value at " + i + "th index :");
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
//        for (int i=0;i<n ; i++){
//            System.out.print(array[i]+"\t");
//        }
        System.out.println("Enter the number you want to find : ");
        int test= sc.nextInt();
        int low=0;
        int high=n-1;
        int mid = 0;
        boolean a = false;
        while(low <= high){
            mid=(low+high)/2;
            if(array[mid]==test){
                a=true;
                break;
            }
            else if (array[mid]<test) {
                low = mid+1;
            }
            else {
                high=mid-1;
            }
        }
        if (a==true){
            System.out.println("The number "+test+" is in the index "+mid);
        }
        else {
            System.out.println("The number is not present in the array");
        }
    }
}