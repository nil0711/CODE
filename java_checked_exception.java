import java.io.*;
import java.util.Scanner;


class java_checked_exception {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        Scanner sc= new Scanner(System.in);
        FileInputStream test=null;
        while (true){
            System.out.println("Enter 1 for FileNotFoundException, 2 for ClassNotFoundException");
            int choice = sc.nextInt();
        switch (choice){
            case 1:try {
            test= new FileInputStream("/home/anon/test.text");
        }catch (FileNotFoundException e1){
            System.out.println(e1);
            System.out.println("File does not exist");
        }
        break;
            case 2:try {
            Class temp=Class.forName("sample");
        }catch (ClassNotFoundException e2){
            System.out.println(e2);
            System.out.println("Class not found");
        }
        break;
        }
        }
    }
}
