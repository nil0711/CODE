import java.util.ArrayList;
import java.util.Scanner;

class CircularQueue{

    // Declaring the class variables.
    private final int size;
    private int front;
    private int rear;

    // Declaring array list of integer type.
    private final ArrayList<Integer> queue = new ArrayList<Integer>();

    // Constructor
    CircularQueue(int size)
    {
        this.size = size;
        this.front = this.rear = -1;
    }

    // Method to insert a new element in the queue.
    public void enQueue(int data)
    {

        // Condition if queue is full.
        if((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1)))
        {
            System.out.println("Queue is Full");
        }

        // condition for empty queue.
        else if(front == -1)
        {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        }

        else if(rear == size - 1 && front != 0)
        {
            rear = 0;
            queue.set(rear, data);
        }

        else
        {
            rear = (rear + 1);

            // Adding a new element if
            if(front <= rear)
            {
                queue.add(rear, data);
            }

            // Else updating old value
            else
            {
                queue.set(rear, data);
            }
        }
    }

    // Function to dequeue an element
// from th queue.
    public int deQueue()
    {
        int temp;

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");

            // Return -1 in case of empty queue
            return -1;
        }

        temp = queue.get(front);

        // Condition for only one element
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }

        else if(front == size - 1)
        {
            front = 0;
        }
        else
        {
            front = front + 1;
        }

        // Returns the dequeued element
        return temp;
    }

    // Method to display the elements of queue
    public void displayQueue()
    {

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.println("Queue is Empty");
            return;
        }

        // If rear has not crossed the max size
        // or queue rear is still greater than
        // front.
        System.out.print("Elements in the " +
                "circular queue are: ");

        if(rear >= front)
        {

            // Loop to print elements from
            // front to rear.
            for(int i = front; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }

        // If rear crossed the max index and
        // indexing has started in loop
        else
        {

            // Loop for printing elements from
            // front to max size or last index
            for(int i = front; i < size; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }

            // Loop for printing elements from
            // 0th index till rear position
            for(int i = 0; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static class lab_circular_queue_implementation {
        public static void main(String[] args)
        {

            // Initialising new object of
            // CircularQueue class.
            CircularQueue q = new CircularQueue(5);
            Scanner sc=new Scanner(System.in);
            while(true) {
                System.out.println("Press 1 to enqueue, 2 to dequeue, 3 to display queue, 4 to exit");
                int a = sc.nextInt();
                switch (a) {
                    case 1://enqueue
                        System.out.println("Enter data to enqueue");
                        int data = sc.nextInt();
                        q.enQueue(data);
                        break;
                    case 2://dequeue
                        int x = q.deQueue();

                        // Checking for empty queue.
                        if (x != -1) {
                            System.out.print("Deleted value = ");
                            System.out.println(x);
                        }
                        break;
                    case 3://display queue
                        q.displayQueue();
                        break;
                }
                if (a == 4) {
                    break;
                }
            }

    }
}}
