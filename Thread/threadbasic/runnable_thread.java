package Thread.threadbasic;
class newThread implements Runnable{
    Thread t;
    int num;
    newThread(int num){
        t = new Thread(this,"Runnable Thread");
       this.num=num;
        t.start();
    }
    @Override
    public void run() {
        for(int n=10;n>0;n--){
            System.out.println("Child Thread "+num+" executes "+n);
            if(num==2){
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Child Thread Interrupted");
                }
            } else if (num==1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Child Thread Interrupted");
                }
            }
        }
        System.out.println("Exiting child thread "+num+" ...");
    }
}
public class runnable_thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Started");
        newThread obj1=new newThread(1);
        newThread obj2=new newThread(2);
        System.out.println("Thread 1 is alive "+obj1.t.isAlive());
        System.out.println("Thread 2 is alive "+obj2.t.isAlive());

        obj1.t.join();
        System.out.println("Main thread Ended");
    }
}
