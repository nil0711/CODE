import java.util.*;

public class linear_search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int n=sc.nextInt();
        int [] array=new int[n];
        for (int i=0;i<n ; i++){
            System.out.println("Enter the value at "+i+"th index :");
            array[i]= sc.nextInt();
        }
//        for (int i=0;i<n ; i++){
//            System.out.print(array[i]+"\t");
//        }
        System.out.println("Enter the number you want to find : ");
        int test= sc.nextInt();
        boolean a = false;
        int j = 0;
        for (int i=0;i<n ; i++){
            if(test==array[i]){
                a=true;
                j=i;
                break;
            }
        }
        if (a==true){
            System.out.println("The number "+test+" is in the index "+j);
        }
        else {
            System.out.println("The number is not present in the array");
        }

    }
}
