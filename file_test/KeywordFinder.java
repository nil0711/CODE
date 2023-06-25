package file_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KeywordFinder {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("file_test/file.txt"); // Replace with the actual filename
        String keyword = "code"; // Replace with the keyword you want to find
        int position=0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            position++;
            String line = scanner.nextLine();
            if (line.contains(keyword)) {
                System.out.println("Keyword found in line: "+position);
            }
        }
        scanner.close();
    }
}

