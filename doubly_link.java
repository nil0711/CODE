import java.util.Scanner;

class double_link_list{
    Node head=null;
    Node tail=null;
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
        void pointerReversal(Node next, Node prev){
            Node pointer=next;
            next=prev;
            prev=pointer;
        }
    }
//    Checking if link list is empty
    boolean isEmpty(){
        return size==0;
    }
//    Add first
    void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        size++;
    }
//    Add last
    void  addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        size++;
    }
//    Forward printing. That is printing from the head
    void printFromHead(){
        if(isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("Printing from head to tail");
        Node currNode =head;
        System.out.print("NULL <->");
        do{
            System.out.print(currNode.data+" <-> ");
            if (currNode==tail)break;
            currNode=currNode.next;
        }while (true);
        System.out.print("NULL");
        System.out.println();
    }
//    Backward printing. That is printing from the tail
    void printFromTail(){
        if(isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("Printing from tail to head");
        Node currNode=tail;
        System.out.print("NULL <->");
        do{
            System.out.print(currNode.data+" <-> ");
            if (currNode==head)break;
            currNode=currNode.prev;
        }while (true);
        System.out.print("NULL");
        System.out.println();
    }
//    Printing size of the list
    void printListSize(){
        System.out.println("Size of list is "+size);
    }
//    Deleting first element of the link list
    void deleteFirst(){
        if(isEmpty()){
            return;
        }
        if(head.next==null){
            System.out.println("TreeTraversal.Node "+head.data+" is deleted");
            head=null;
            size=0;
            return;
        }
        System.out.println("TreeTraversal.Node "+head.data+" is deleted");
        Node currNode = head;
        currNode=currNode.next;
        head=currNode;
        head.prev=null;
        size--;
    }
//    Deleting last element of the link list
    void deleteLast(){
        if(isEmpty()){
            return;
        }
        if(tail.prev==null){
            System.out.println("TreeTraversal.Node "+tail.data+" is deleted");
            tail=null;
            size=0;
            return;
        }
        System.out.println("TreeTraversal.Node "+tail.data+" is deleted");
        Node currNode = tail;
        currNode=currNode.prev;
        tail=currNode;
        tail.next=null;
        size--;
    }
//    Reversing the Link List
    void reverseList(){
        if(head==null || head.next==null){
            return;
        }
        Node prevNode= head;
        Node currNode=head.next;
        while (currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;
            currNode.prev=nextNode;
//            update
            prevNode=currNode;
            currNode=nextNode;
        }
        Node temp=head;
        head=tail;
        tail=temp;
        head.prev=null;
        tail.next=null;
    }
//        inserting element in ith position
    void insertElement(int n, String data){
        if(n>size){
            System.out.println("Position does not exist");
            return;
        }
        Node newNode= new Node(data);
        Node currNode = head;
        if(n==1) {
            addFirst(data);
            return;
        }
        for (int i=1;i<n-1;i++){
            currNode=currNode.next;
        }
        newNode.next=currNode.next;
        newNode.prev=currNode;
        newNode.next.prev=newNode;
        currNode.next=newNode;
        size++;
    }
//        replacing a node in nth position
    void replaceNode(int n, String data){
        if(n>size){
            System.out.println("Position does not exist");
            return;
        }
        Node newNode= new Node(data);
        Node currNode = head;
        if(n==1) {
            head=newNode;
            return;
        }
        if (n!=1&&n==size) {
            deleteLast();
            addLast(data);
            return;
        }

        for (int i=1;i<n-1;i++){
            currNode=currNode.next;
        }
        newNode.next=currNode.next.next;
        currNode.next=newNode;
        newNode.prev=currNode;
        newNode.next.prev=newNode;
    }
//        deleting a node in nth position
    void deleteNode(int n){
        if(n>size){
            System.out.println("Position does not exist");
            return;
        }
        Node currNode = head;
        if(n==1) {
            deleteFirst();
            size--;
            return;
        }
        if (n!=1&&n==size) {
            deleteLast();
            size--;
            return;
        }

        for (int i=1;i<n-1;i++){
            currNode=currNode.next;
        }
        currNode.next=currNode.next.next;
        currNode.next.prev=currNode;
        size--;
    }

}
public class doubly_link{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double_link_list test = new double_link_list();
        while (true) {
            System.out.println("Press 1 to add first, press 2 to add last, press 3 to delete first, press 4 to delete last, press 5 to insert element at ith position, ");
            System.out.println("press 6 to replace element at ith position, press 7 to delete element in ith position, press 8 to reverse the list and press 9 to exit");
            int choice = sc.nextInt();
            if(choice==1){
//                inserting element in front
                System.out.println("Enter the element you want to insert");
                String data = sc.next();
                test.addFirst(data);
                test.printFromHead();
                test.printListSize();
            } else if (choice==2) {
//                inserting element at end
                System.out.println("Enter the element you want to insert");
                String data = sc.next();
                test.addLast(data);
                test.printFromHead();
                test.printListSize();
            } else if (choice==3) {
//                deleting element from front
               test.deleteFirst();
               test.printFromHead();
               test.printListSize();
            } else if (choice==4) {
//                deleting element from end
                test.deleteLast();
                test.printFromHead();
                test.printListSize();
            } else if (choice==5) {
//              inserting node at ith position
                System.out.println("Enter the position where you want to enter the element");
                int n = sc.nextInt();
                System.out.println("Enter the element");
                String data=sc.next();
                test.insertElement(n,data);
                test.printFromHead();
            } else if (choice==6) {
//                replacing node at ith position
                System.out.println("Enter the position where you want to replace the element");
                int n = sc.nextInt();
                System.out.println("Enter the new element");
                String data=sc.next();
                test.replaceNode(n,data);
                test.printFromHead();
            } else if (choice==7) {
//              deleting node at ith position
                System.out.println("Enter the position where you want to delete the element");
                int n = sc.nextInt();
                test.deleteNode(n);
                test.printFromHead();
            } else if (choice==8) {
//                reversing the list
                test.reverseList();
                test.printFromHead();
                test.printListSize();
            }
            if(choice==9){
//                exiting the user input loop
                break;
            }
        }
    }
}
