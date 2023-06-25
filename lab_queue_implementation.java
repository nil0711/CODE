import java.util.Scanner;

class Queue {

    private static int front, rear, capacity;
    private static int[] queue;

    Queue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // insert an element into the queue
    static void queueEnqueue(int item)  {
        // check if the queue is full
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        }

        // insert element at the rear
        else {
            queue[rear] = item;
            rear++;
        }
    }

    //remove an element from the queue
    static void queueDequeue()  {
        // check if queue is empty
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }

        // shift elements to the right by one place until rear
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }


            // set queue[rear] to 0
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
    }

    // print queue elements
    static void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }

    // print front of queue
    static void queueFront()
    {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element of the queue: "+ queue[front]);
    }
}
public class lab_queue_implementation {
    public static void main(String[] args) {
        // Create a queue of capacity 4
        Queue q = new Queue(4);
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Press 1 to enqueue, 2 to dequeue, 3 to peek, 4 to print, 5 to exit");
            int a = sc.nextInt();
            switch (a) {
                case 1://enqueue
                    System.out.println("Enter the data to enter in the queue");
                    int data = sc.nextInt();
                    q.queueEnqueue(data);
                    break;
                case 2://dequeue
                    q.queueDequeue();
                    System.out.println("Done");
                    break;
                case 3://peek
                    q.queueFront();
                    break;
                case 4://print
                    q.queueDisplay();
                    break;
            }
            if (a == 5) {
                break;
            }
        }

    }
}
