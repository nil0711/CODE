import java.util.Scanner;

class link_list_circular{
    Node head=null;
    Node tail=null;
    private int size=0;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=head;
        }
    }
//    add first
    void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head=newNode;
            tail=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
    }
//    add Last
    void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head=newNode;
            tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
    }
//    delete first
    void deleteFirst(){
        if(head==null){
            return;
        }
        if(head.next==head){
            System.out.println("Element "+head.data+" deleted from the list");
            head=null;
            tail=null;
            size=0;
            return;
        }
        System.out.println("Element "+head.data+" deleted from the list");
        head=head.next;
        size--;
    }
//    delete last
    void deleteLast(){
        if(head==null){
            return;
        }
        if(head.next==head){
            System.out.println("Element "+head.data+" deleted from the list");
            head=null;
            tail=null;
            size=0;
            return;
        }
        Node currNode = head;
        while (currNode.next!=tail){
            currNode=currNode.next;
        }
        System.out.println("Element "+tail.data+" deleted from the list");
        tail=currNode;
        size--;
    }
//    printing link list
    void printList(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The link list is ");
        Node currNode=head;
        while (true){
            System.out.print(currNode.data+" -> ");
            if (currNode==tail)break;
            currNode=currNode.next;
        }
        System.out.print(head.data);
        System.out.println();
        System.out.println("The size of the link list is "+size);
    }
    //    inserting element in ith position
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
        currNode.next=newNode;
        size++;
    }
    //    replacing a node in nth position
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
    }
    //    deleting a node in nth position
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
        size--;
    }
//        list reversal
    public void reverse_list_iterative(){
//        iterative method
        if(head==null || head.next==head){
            return;
        }
        Node prevNode=head;
        Node currNode=head.next;
        while (currNode!=head){
            Node nextNode=currNode.next;
            currNode.next=prevNode;

//            update
            prevNode=currNode;
            currNode=nextNode;
        }
        Node temp = head;
        head=tail;
        tail=temp;
        tail.next=head;
    }

}
public class circular_link_list {
    public static void main(String[] args) {
//        Creating scanner object and circular link list object
        Scanner sc = new Scanner(System.in);
        link_list_circular test = new link_list_circular();
//        Creating an infinite while loop for continuous user input
        while (true){
            System.out.println("Press 1 for add first, press 2 for add last, press 3 for delete first, press 4 for delete last, ");
            System.out.println("press 5 for inserting element in ith position, press 6 for replacing a node in ith position, ");
            System.out.println("press 7 for deleting a node in ith position,press 8 for reversing the list and press 9 for exit");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println("Enter the element you want to add");
                String data=sc.next();
                test.addFirst(data);
                test.printList();
            } else if (choice==2) {
                System.out.println("Enter the element you want to add");
                String data =sc.next();
                test.addLast(data);
                test.printList();
            } else if (choice==3) {
                test.deleteFirst();
                test.printList();
            } else if (choice==4) {
                test.deleteLast();
                test.printList();
            } else if (choice==5) {
                System.out.println("Enter the position where you want to insert the element");
                int n=sc.nextInt();
                System.out.println("Enter the element you want to add");
                String data=sc.next();
                test.insertElement(n,data);
                test.printList();
            } else if (choice==6) {
                System.out.println("Enter the position where you want to replace the element");
                int n=sc.nextInt();
                System.out.println("Enter the element you want to add");
                String data=sc.next();
                test.replaceNode(n,data);
                test.printList();
            } else if (choice==7) {
                System.out.println("Enter the position where you want to delete the element");
                int n=sc.nextInt();
                test.deleteNode(n);
                test.printList();
            } else if (choice==8) {
//                replacing node at ith position
                System.out.println("Enter the position where you want to replace the element");
                int n = sc.nextInt();
                System.out.println("Enter the new element");
                String data=sc.next();
                test.replaceNode(n,data);
                test.printList();
            }
            if(choice==9){
                break;
            }
        }
    }
}
