package fileSource;
import java.io.*;
import java.util.Scanner;
public class copyFile {
    public static void main(String[] args) throws IOException {

        File myFile1 = new File("fileSource/test123.txt");

            myFile1.createNewFile();
            System.out.println("File "+myFile1.getName()+" created in Source");


            FileWriter fileWriter = new FileWriter("fileSource/test123.txt");
            fileWriter.write("This file needs to be copied...!");
            fileWriter.close();
        System.out.println("Do you want to copy file into destination folder...? Enter yes/n");
        Scanner sc = new Scanner(System.in);
        String choice=sc.next();
        File myFile2 = new File("destination/test123.txt");

            myFile2.createNewFile();
            System.out.println("File "+myFile2.getName()+" created in Destination");
        Scanner scanFile=new Scanner(new File("fileSource/test123.txt"));
        FileWriter copyContent = new FileWriter(new File("destination/test123.txt"));
        if(choice.equalsIgnoreCase("yes")){
            while (scanFile.hasNextLine()){
                copyContent.write(scanFile.nextLine());
                copyContent.write("\n");
            }
            System.out.println("File copied successfully...!");
            scanFile.close();
            copyContent.close();
        }else {
            if (choice.equalsIgnoreCase("n")) {
                System.out.println("User denied file copy...!");
            } else {
                System.out.println("Invalid input. Did not copy file...!");
            }
        }

    }
}
