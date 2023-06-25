package Thread.Syncronization;

import java.util.concurrent.ThreadLocalRandom;

public class lab_output {

    public static void main(String[] args) {

        // Create three threads
        Thread t1 = new Thread(new NumberPrinter(101, 110));
        Thread t2 = new Thread(new NumberPrinter(201, 210));
        Thread t3 = new Thread(new NumberPrinter(301, 310));

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }

    private static class NumberPrinter implements Runnable {

        private int startNumber;
        private int endNumber;

        public NumberPrinter(int startNumber, int endNumber) {
            this.startNumber = startNumber;
            this.endNumber = endNumber;
        }

        @Override
        synchronized public void run() {
            for (int i = startNumber; i <= endNumber; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

