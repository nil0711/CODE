package file_test;
import java.io.*;

public class FindReplace {

        public static void main(String[] args) {
            // Replace "file.txt" with the name of your text file
            String fileName = "file.txt";
            String findWord = "Anu";
            String replaceWord = "Sai";

            try {
                // Create a temporary file
                File tempFile = new File("temp.txt");
                PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

                // Open the original file for reading
                BufferedReader reader = new BufferedReader(new FileReader(fileName));

                // Loop through each line of the file
                String line = null;
                while ((line = reader.readLine()) != null) {
                    // Replace the word in the line
                    line = line.replaceAll(findWord, replaceWord);

                    // Write the modified line to the temporary file
                    writer.println(line);
                }

                // Close the streams
                reader.close();
                writer.close();

                // Replace the original file with the temporary file
                File originalFile = new File(fileName);
                originalFile.delete();
                tempFile.renameTo(originalFile);

                System.out.println("Successfully replaced all occurrences of '" + findWord + "' with '" + replaceWord + "'.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
