package Threads_syncronized_asyncronized;

public class RaceConditionExample {
    private static int counter = 0;

    private  static void increment(){
        for (int i = 0 ; i<100000; i++)counter++;
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i <= 100 ; i++){
            Thread t = new Thread(()-> increment());
            t.start();
        }

        System.out.println("Counter value: " + counter);
    }
}

