package Thread.Syncronization;

public class lab_output_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumbers(101, 110));
        Thread t2 = new Thread(new PrintNumbers(201, 210));
        Thread t3 = new Thread(new PrintNumbers(301, 310));

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintNumbers implements Runnable {
    private int startNum;
    private int endNum;

    public PrintNumbers(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }
    synchronized void print(){
        for (int i = startNum; i <= endNum; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    @Override
    public void run() {
        print();
    }
}


