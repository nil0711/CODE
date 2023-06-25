import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class file_io_stream {
    public static void main(String[] args) throws IOException {
//        File file = new File("Hello.txt");
//        System.out.println("We got a new file "+file.getName());
//
//        System.out.println("Does it exist? "+file.exists());
//
//        System.out.println("Wat? "+file.isDirectory());
//        String contenToWrite="Hello World";
//
//        OutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(contenToWrite.getBytes());
//        outputStream.close();

//        File file = new File("Hello.txt");
//        Scanner sc = new Scanner(file);
//        if(sc.hasNextLine()){
//            String line = sc.nextLine();
//            System.out.println(line);
//        }
//        sc.close();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        String line = reader.readLine();
//        reader.close();
//        System.out.println(line);

        URL url =  new URL("https://itsfoss.com/install-latest-eclipse-ubuntu/");
        InputStream stream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        File file = new File("Hello.txt");
        OutputStream outputStream = new FileOutputStream(file);
        String line = reader.readLine();
         while (line!= null){
             outputStream.write(line.getBytes());
             line= reader.readLine();
         }
        reader.close();
        System.out.println("Done writing");



    }
}
