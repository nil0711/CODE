import java.time.*;

class java_unchecked_exception {
    public static void main(String[] args) {
        try{
            int data=50/0;
        }catch(ArithmeticException e1){
            System.out.println(e1);}
        System.out.println("rest of the code...");
        try {
            String s=null;
            System.out.println(s.length());
        }catch (NullPointerException e2) {
            System.out.println(e2);
        }
        System.out.println("rest of the code...");
        try {
            String s="Testing this String";
            int i=Integer.parseInt(s);
        }catch (NumberFormatException e3) {
            System.out.println(e3);
        }
        System.out.println("rest of the code...");
        try {
            int[] a =new int[8];
            a[15]=9;
        }catch (ArrayIndexOutOfBoundsException e4){
            System.out.println(e4);
        }
        System.out.println("rest of the code...");
        try {
            LocalTime invalidTime = LocalTime.of(30,18);
        } catch (DateTimeException e5) {
            System.out.println(e5);
        }
        System.out.println("rest of the code...");
    }

}
