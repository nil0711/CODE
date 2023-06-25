package ReaderWriterThread;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements  Runnable {
    ObjectInputStream ois;
    String name;
    ReaderThread(ObjectInputStream ois, String name){
        this.ois=ois;
        this.name=name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object received = ois.readObject();
                System.out.println(name + " Got: " + (String) received);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
