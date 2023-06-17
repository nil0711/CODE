import java.util.*;
public class java_array_sum_5 {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5};
        int t=0;
        for (int i=0;i<2;i++){
            t=arr[i];
            arr[i]=arr[4-i];
            arr[4-i]=t;
        }
        for (int i = 0; i < 5; i++) {
                System.out.print(arr[i]);

        }
    }
}