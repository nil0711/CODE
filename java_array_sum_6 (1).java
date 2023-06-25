import java.util.*;
public class java_array_sum_6 {
    public static void main(String[] args) {
        int [] arr={1,2,10,4,5};
        int k=arr[0];
        for(int i=-0;i<5;i++){
            if(k>arr[i]) {
                continue;
            }
            else {
                k=arr[i];
            }
            }
        System.out.println(k);
        }
    }

