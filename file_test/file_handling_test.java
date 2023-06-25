package file_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class file_handling_test {
    public static void main(String[] args) {
        File myFile = new File("file_test/file.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter fileWriter = new FileWriter("file_test/file.txt");
            fileWriter.write("Sample file" );
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner sc2 = new Scanner(myFile);
            int a=0;
            while (sc2.hasNextLine()){
                System.out.println(sc2.nextLine());
            }
            System.out.println(a);
            sc2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
