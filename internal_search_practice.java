import java.util.Scanner;
class enter_values{
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[10];
    void enter_values_in_array(){
        for(int i = 0; i<10;i++){
            System.out.println("Enter the element at "+i+"th place");
            arr[i]=sc.nextInt();
        }
    }
    void display_array(){
        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
    void sort_array(){
        for (int i=0; i< arr.length;i++){
            for(int j=i;j< arr.length;j++){
                if(arr[i]>arr[j]){
                    arr[i]=(arr[i])^(arr[j]);
                    arr[j]=(arr[i])^(arr[j]);
                    arr[i]=(arr[i])^(arr[j]);
                }
            }
        }
    }
    void display_sorted_array(){
        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
}
class linear_search_ extends enter_values{
            void search_for_number(int number){
                int i;
                for (i=0;i<10;i++){
                    if(arr[i]==number){
                        System.out.println("The number "+number+" is found at "+i+"th index");
                        return;
                    }
                }
                System.out.println("The number is not in the list");
    }
}
class binary_search_ extends enter_values{
       int search_for_number(int number, int h, int l){
            int mid = (l+h)/2;
            if(number>arr[h]||number<arr[l]){
                return 0;
            }
            if(number==arr[mid]){
                System.out.println("The number "+number+" is found in the "+mid+"th index");
                return 1;
            }
            if(number==arr[h]){
                System.out.println("The number "+number+" is found in the "+h+"th index");
                return 1;
            }
            if(number==arr[l]){
                System.out.println("The number "+number+" is found in the "+l+"th index");
                return 1;
            }
            if(number<arr[mid]){
                search_for_number(number,mid-1,l+1);
            }
            if (number>arr[mid]){
                search_for_number(number,h-1,mid+1);
            }
            return 0;
        }
}
class fibonacci_search_ extends enter_values{
    public static int min(int x, int y)
    {
        return Math.min(x, y);
    }
    int search_for_number(int number, int n){
        int fib2=0;
        int fib1=1;
        int fibn=fib1+fib2;

        while (fibn<n){
            fib2=fib1;
            fib1=fibn;
            fibn=fib1+fib2;
        }

        int offset=-1;

        while ((fibn>1)){
            int i=min(offset+fib2,n-1);

            if(arr[i]<number){
                fibn=fib1;
                fib1=fib2;
                fib2=fibn-fib1;
                offset=i;
            }
            else if (arr[i]>number) {
                fibn=fib2;
                fib1=fib1-fib2;
                fib2=fibn-fib1;
            }
            else {
                System.out.println("The number " + number + " is at " + i + "th index");
                return 1;
            }
        }
        if (fib1==1&&arr[n-1]==number)return 0;
        return 0;
    }

}
public class internal_search_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        linear search
        linear_search_ test1 = new linear_search_();
        test1.enter_values_in_array();
        test1.display_array();
        System.out.println();
        test1.sort_array();
        test1.display_sorted_array();
        System.out.println();
        System.out.println("Enter the number you want to find");
        int number1 = sc.nextInt();
        test1.search_for_number(number1);


//        binary search
        binary_search_ test2 = new binary_search_();
        test2.enter_values_in_array();
        test2.display_array();
        System.out.println();
        test2.sort_array();
        test2.display_sorted_array();
        System.out.println();
        System.out.println("Enter the number you want to find");
        int number2= sc.nextInt() ;
        if(test2.search_for_number(number2,9,0)==0)System.out.println("The number is not in the list");

//        fibonacci search
        fibonacci_search_ test3 = new fibonacci_search_();
        test3.enter_values_in_array();
        test3.display_array();
        System.out.println();
        test3.sort_array();
        test3.display_sorted_array();
        System.out.println();
        System.out.println("Enter the number you want to find");
        int number3= sc.nextInt() ;
        if(test3.search_for_number(number3,10)==0)System.out.println("The number is not in the list");
    }
}
