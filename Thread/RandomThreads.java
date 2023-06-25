package Thread;

import java.util.Random;

public class RandomThreads {

    public static void main(String[] args) {

        Thread t1 = new Thread(new PrintNumbers(100));
        Thread t2 = new Thread(new PrintNumbers(200));
        Thread t3 = new Thread(new PrintNumbers(300));



        t1.start();
        t2.start();
        t3.start();

    }
}

class PrintNumbers implements Runnable {
    Random rand = new Random();

    private int start;

    public PrintNumbers(int start) {
        this.start = start;
    }

    public void run() {
        for (int i = start; i < start + 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is printing " + i);
            try {
                Thread.sleep(rand.nextInt(500,2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

