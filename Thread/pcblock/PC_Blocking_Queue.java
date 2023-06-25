package Thread.pcblock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class PC_Blocking_Queue {
    public static void main(String[] args) {
        BlockingQueue<String> q= new ArrayBlockingQueue<>(4);
        Producer producer1= new Producer(q,"Producer1");
        Consumer consumer1=new Consumer(q,"Consumer1");
        Consumer consumer2=new Consumer(q,"Consumer2");
        Consumer consumer3=new Consumer(q,"Consumer3");
        Consumer consumer4=new Consumer(q,"Consumer4");
    }
}
