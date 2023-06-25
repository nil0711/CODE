package Threads_syncronized_asyncronized;

class printNumber implements Runnable{
    int start;
    int ThreadNumber;

    printNumber(int start, int ThreadNumber){
        this.start=start;
        this.ThreadNumber=ThreadNumber;
    }

    @Override
    public void run() {
        for (int i=0; i<=10;i++){
            System.out.println("Thread "+ThreadNumber+" is printing "+(start+i));
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
public class MakeThreads {
    public static void main(String[] args) throws InterruptedException {
        for (int i=1;i<4;i++) {
            printNumber printNumber = new printNumber((i * 100), i);
            Thread t = new Thread(printNumber);
            t.start();
            Thread.sleep(333);
        }
    }
}
