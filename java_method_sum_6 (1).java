import java.util.*;
public class java_method_sum_6 {
    static int avg( int ...arr){
        int sum=0,i=0;
        for (int a:arr) {
            sum+=a;
            i++;
        }
        return (sum/i);
    }

    public static void main(String[] args) {
        System.out.println(avg(1,2,3,4,5));
    }
}
