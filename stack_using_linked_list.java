import java.util.Scanner;

class stack_{
    private Node head;
    private Node tail;
    private int size=0;
    static class Node{
        String data;
        Node next;
        Node prev;
        Node(String data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    boolean isEmpty(){
        return (head==null)||(tail==null);
    }
    void push(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        tail.next=null;
        size++;
    }
    void pop(){
        if(isEmpty())return;
        if(tail.prev==null){
            System.out.println(tail.data+" popped");
            tail=null;
            size=0;
            return;
        }
        System.out.println(tail.data+" popped");
        Node currNode = tail;
        currNode=currNode.prev;
        tail=currNode;
        tail.next=null;
        size--;
    }
    String peek(){
        return tail.data;
    }
    void printStack(){
        if(isEmpty()) {
            System.out.println("The stack is empty");
            return;
        }
        Node currNode = tail;
        System.out.println("Printing stack");
        System.out.println();
        while (currNode!=null){
            System.out.println("|  "+currNode.data+"  |");
            currNode=currNode.prev;
        }
        System.out.println("-------");
        System.out.println("Size of stack is "+size);
    }
}
public class stack_using_linked_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack_ test = new stack_();
        while(true){
            System.out.println("Press 1 to push into stack, press 2 to pop from stack, press 3 to peek and 4 to exit");
            int choice = sc.nextInt();
            if (choice==1){
                System.out.println("Enter element you want to push");
                String data=sc.next();
                test.push(data);
                test.printStack();
            } else if (choice==2) {
                test.pop();
                test.printStack();
            } else if (choice==3) {
                System.out.println("Element on top is "+test.peek());
            }
            if (choice==4)break;
        }
    }
}
