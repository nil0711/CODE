import  java.util.Scanner;
public class java_array_sum1 {
    public static void main(String[] args) {
        float [] number=new float[5];
        Scanner sc= new Scanner(System.in);
        for(int i=0; i < number.length; i++){
        System.out.print("Enter value of array index "+(i+1)+" : ");
        number[i]= sc.nextFloat();
            System.out.println();
        }
        float sum=0.0f;
        for(int i=0; i < number.length; i++){
            sum=sum+number[i];
        }
        for (float element : number){
            System.out.print(element+"\t");
        }
        System.out.println("\n");
        System.out.println(sum);
    }
}
