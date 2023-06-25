import java.io.*;

public class CheckedExceptions {

    public static void main(String[] args) {

        try {
            // Example 1: FileNotFoundException
            FileReader file = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException");
        }

        try {
            // Example 2: IOException
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line = reader.readLine();
        } catch (IOException e) {
            System.out.println("Caught IOException");
        }

        try {
            // Example 3: InterruptedException
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Caught InterruptedException");
        }

        try {
            // Example 4: ClassNotFoundException
            Class.forName("com.example.ClassThatDoesNotExist");
        } catch (ClassNotFoundException e) {
            System.out.println("Caught ClassNotFoundException");
        }

        try {
            // Example 5: IllegalAccessException
            Class<?> c = System.class;
            c.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Caught InstantiationException");
        } catch (IllegalAccessException e) {
            System.out.println("Caught IllegalAccessException");
        }
    }
}
