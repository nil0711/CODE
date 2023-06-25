package Thread.Syncronization;

class PrintThread implements Runnable {
    private int startNum;
    private Object lock;
    private Object nextLock;

    public PrintThread(int startNum, Object lock, Object nextLock) {
        this.startNum = startNum;
        this.lock = lock;
        this.nextLock = nextLock;
    }

    @Override
    public void run() {
        for (int i = startNum; i <= startNum + 10; i++) {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    if (i != startNum + 10) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (nextLock) {
                    nextLock.notify();
                }
            }
        }
    }
}
public class lab_output_3 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();

        Thread t1 = new Thread(new PrintThread(100, lock1, lock2), "Thread-1");
        Thread t2 = new Thread(new PrintThread(200, lock2, lock3), "Thread-2");
        Thread t3 = new Thread(new PrintThread(300, lock3, lock1), "Thread-3");

        try {
            synchronized (lock1) {
                t1.start();
                lock1.wait();
                t2.start();
                lock2.wait();
                t3.start();
                lock3.notify();
            }
            t3.join(); // wait for t3 to finish before ending the program
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
