package Thread.pcblock;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<String> q;
    Thread t;
    String name;
    Consumer(BlockingQueue<String>q, String name){
        this.q = q;
        this.name=name;
        t=new Thread(this,name);
        t.start();
    }
    @Override
    public void run() {
        while(true){
            try {
                if(q.size()==0){
                    System.out.println(name+" : Queue is empty...");
                    Thread.sleep(3000);
                }
                System.out.println(name+" got "+q.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
