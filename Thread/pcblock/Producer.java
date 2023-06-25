package Thread.pcblock;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{
    BlockingQueue<String> q;
    Thread t;
    String name;
    Producer(BlockingQueue<String>q, String name){
        this.q = q;
        this.name=name;
        t=new Thread(this,name);
        t.start();
    }
    @Override
    public void run() {
        int i=0;
        while(true){

            try {
                if(q.size()>=4){
                    System.out.println(name+" Queue is full...");
                    Thread.sleep(1000);
                }
                q.put(" cake "+(i+1));
                System.out.println(name+" created cake "+(i+1));
                i++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}