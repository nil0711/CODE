package Thread.threadbasic;

public class main_thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread "+t);
//        change name of current thread
        t.setName("My thread");
        System.out.println("After name change "+t);
        for(int n=10;n>0;n--){
            System.out.println(n);
            Thread.sleep(500);
        }

    }
}
