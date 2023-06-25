import java.util.Scanner;

class PriorityQueue {
    private final int MAX;
    private final int[] intArray;
    private int itemCount;


    public PriorityQueue(int size){
        MAX = size;
        intArray = new int[MAX];
        itemCount = 0;
    }

    public void insert(int data){
        int i =0;

        if(!isFull()){
            // if queue is empty, insert the data
            if(itemCount == 0){
                intArray[itemCount++] = data;
            }else{
                // start from the right end of the queue
                for(i = itemCount - 1; i >= 0; i-- ){
                    // if data is larger, shift existing item to right end
                    if(data > intArray[i]){
                        intArray[i+1] = intArray[i];
                    }else{
                        break;
                    }
                }
                // insert the data
                intArray[i+1] = data;
                itemCount++;
            }
        }
    }

    public int remove(){
        itemCount--;
        return intArray[itemCount];
    }

    public int peek(){
        return intArray[itemCount - 1];
    }

    public boolean isEmpty(){
        return itemCount == 0;
    }

    public boolean isFull(){
        return itemCount == MAX;
    }

    public int size(){
        return itemCount;
    }
}
public class lab_priority_queue_implementation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue queue = new PriorityQueue(6);
        while(true){
            System.out.println("Press 1 to insert, 2 to remove, 3 to peek, 4 to print, 5 to exit");
            int a = sc.nextInt();
            switch (a){
                case 1://insert
                    System.out.println("Enter data you want to insert");
                    int data= sc.nextInt();
                    queue.insert(data);
                    break;
                case 2://remove
                    int num = queue.remove();
                    System.out.println("Element removed: "+num);
                    break;
                case 3://peek
                    System.out.println("Element at front: "+queue.peek());
                    break;
                case 4://print
                    System.out.println("----------------------");
                    System.out.println("index : 5 4 3 2  1  0");
                    System.out.println("----------------------");
                    System.out.print("Queue:  ");
                    while(!queue.isEmpty()){
                        int n = queue.remove();
                        System.out.print(n +" ");
                    }
                    System.out.println();
                    break;
            }
            if(queue.isFull()){
                System.out.println("Queue is full!");
            }
            if(a==5){break;}
        }
    }
}
