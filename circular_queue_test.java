import java.util.Scanner;

class circular_queue{
    private int counter=0;
//    Creating queue data structure from array
    int[] queue= new int[6];
//    Setting pointers
    private int front=0;
    private int rear=-1;

//    Checking if element can be added in the queue
    boolean isFull(){
        return ((front==0&&rear==5)||((counter>1)&&(rear==(front-1)%6)));
    }
    boolean isEmpty(){
        return (rear==-1||((counter>1)&&(rear%6)==(front%6)));
    }

//    Adding elements to the queue
    void enqueue(int data){

        if(isFull()) {
            System.out.println("The queue is full");
            return;
        }
            rear = (rear + 1) % 6;
            queue[rear] = data;
            counter++;
    }
//    Deleting elements in the queue
    void dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return;
        }
        System.out.println("Element "+queue[front]+" removed from the queue");
        front = (front + 1) % 6;
    }
//    Fetching the front element
    int peek(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return -1;
        }
        return  queue[front];
    }
//    Printing the queue
    void printQueue(){
        if(isEmpty()){
            return;
        }
        for(int i=0;i <6; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
        System.out.println("front pointer: "+front);
        System.out.println("Rear pointer: "+rear);
    }
    void circularPrintQueue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return;
        }
        int i=front;
        do{
            System.out.print(queue[i]+" ");
            if (i==rear)break;
            i=(i+1)%6;

        }while (true);
        System.out.println();
    }
}
public class circular_queue_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        circular_queue test1= new circular_queue();
        while (true){
            System.out.println("Press 1 to enqueue, press 2 to dequeue, press 3 to peek, press 4 for circular print and press 5 to exit");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println("Enter the element");
                int data = sc.nextInt();
                test1.enqueue(data);
                test1.printQueue();
            } else if (choice==2) {
                test1.dequeue();
                test1.printQueue();
            } else if (choice==3){
                System.out.println("The element in front is "+test1.peek());
            } else if (choice==4) {
                System.out.println("Printing the queue in circular order");
                test1.circularPrintQueue();
            }
            if(choice==5) break;
        }
    }
}
