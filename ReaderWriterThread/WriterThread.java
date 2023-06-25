package ReaderWriterThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriterThread implements Runnable {
    private ObjectOutputStream oos;
    private String name;
    WriterThread(ObjectOutputStream oos,String name){
        this.oos=oos;
        this.name=name;
        new Thread(this).start();
    }
    @Override
    public void run() {
        Scanner input=new Scanner(System.in);
        while (true){
            String message = input.nextLine();
            try {
                oos.writeObject(message );
                System.out.println("Message Sent...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
