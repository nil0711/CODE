package file_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KeywordReplacer {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String filename = "file_test/file.txt";
        System.out.print("Enter the keyword to replace: ");
        String keyword = input.nextLine();
        System.out.print("Enter the replacement: ");
        String replacement = input.nextLine();
        input.close();

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String content = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(keyword)) {
                line = line.replaceAll(keyword, replacement);
            }
            content += line + "\n";
        }
        scanner.close();
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}

