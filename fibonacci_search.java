import java.util.*;

public class fibonacci_search {
    static int fib(int n){
        if(n==0){return 0;};
        if(n==1){return 1;};
        return fib(n-1)+fib(n-2);
    }
    static int low_fib_index(int n){
        int a=0;
        while (fib(a) < n) {
            a++;
        }
        return a-2;
    }
    static int fibo_search(int n,int m,int p,int[] arr){
        int high = n;
//            System.out.println(high);
        int low=fib(low_fib_index(n));
//            System.out.println(low);
        while (true){

            if(high==0){break;}
            else if (m==low){p=low;break;}
            else if (m==high){p=high;break;}
            else if(m>arr[low]){
                p=p+low;
                int[] array = new int[high - low];
                for(int i = 0;i<(high-low-1);i++){
                    array[i]=arr[low+1+i];
                }
                fibo_search(array.length,m,p,array);
            }
            else {
                high=low-1;
                low=fib(low_fib_index(high));
            }
        }
        return p+1;
    }

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
        int p=0;
        if (fibo_search(array.length, test,p,array)==0){
            System.out.println("The number is not in the array");
        }
        else {
            System.out.println("The number is in the array.");
        }
    }
}