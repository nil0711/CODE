//package Thread.Syncronization;
//
//class Printer{
//      synchronized void printAssignment(Person p){
//        System.out.println(p.name+" -->  Printing Started...");
//        for (int i=0;i<p.pages;i++){
//            System.out.println(p.name+" --> printed page# "+(i+1));
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(p.name+" -->  Printing Ended...");
//    }
//}
//class Person implements Runnable{
//    String name;
//    final Thread.Syncronization.printer printer;
//    int pages;
//
//    Thread t;
//    Person(String name, Thread.Syncronization.printer printer, int pages){
//        this.name=name;
//        this.printer=printer;
//        this.pages=pages;
//        t=new Thread(this,name);
//        t.start();
//    }
//
//    @Override
//     public void run() {
//
//            printer.printAssignment(this);
//    }
//}
//  public class Syncronization {
//    public static void main(String[] args) {
//        printer printer = new printer();
//        Person a = new Person("Anu",printer,5);
//        Person b = new Person("Niloy",printer,7);
//        Person c = new Person("Sai",printer,12);
//    }
//}
