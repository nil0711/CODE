import java.util.Objects;
import java.util.Scanner;

class link_list {
    private  int size =0;
    private boolean size_=false;
   private boolean listNotCircle=true;
    int getSize(){
        return size;
    }
    Node head;
    static class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next =null;
        }
    }
//    add-first, last
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
    }
 public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        Node currNode =head;
        while (currNode.next!=null){
            currNode=currNode.next;
        }
       currNode.next=newNode;
     size++;
    }
//    print
    public void printList(){
        int i=0;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode =head;
        while (currNode!=null){
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next;
            i++;
            if(i>(2*size+1))break;

        }
        System.out.println("NULL");
        if(size_){
            System.out.println("The size of the list is undefined");
            return;
        }
        System.out.println("The size of list is "+size);
    }
//    delete first
    public void deleteFirst(){
        if(head==null){
//            System.out.println("List is empty");
            size=0;
            return;
        }
        head = head.next;
        size--;
    }
//    delete last
    public void deleteLast(){
        if(head==null){
//            System.out.println("List is empty");
            size=0;
            return;
        }
        if(head.next==null){
            head=null;
//            System.out.println("List is empty");
            size=0;
            return;
        }
        Node secondLast = head;
        Node last=head.next;
        while (last.next!=null){
            last=last.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
        size --;
    }
//    list reversal
    public void reverse_list_iterative(){
//        iterative method
        if(head==null || head.next==null){
            return;
        }
        Node prevNode=head;
        Node currNode=head.next;
        while (currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;

//            update
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    public Node reverse_list_recursive(Node head){
//        recursive method
        if(head==null || head.next==null) return head;
        Node newHead =reverse_list_recursive(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
//    Find the nth node from the end delete it
    public void nth_node_find_and_delete(int n){
        if(head==null){
//            System.out.println("List is empty");
            size=0;
            return;
        }
        else if(head.next==null&&n==1){
            System.out.println("The 1st element from end is "+head.data);
            head =null;
            size=0;
            System.out.println("Removed "+n+"st element from end");
            return;
        }
        else if(n>size){
            System.out.println("List size is small.Position does not exist");
            return;
        }
        Node prevNode = head;
        Node currNode=head.next;

        if (n == size) {
            System.out.println("The "+n+"th element from end is "+head.data);
            deleteFirst();
            return;
        }
//        Finding nth node from the end
        for(int i=0;i<size-n-1;i++){
            prevNode=prevNode.next;
            currNode=currNode.next;
        }
        System.out.println("The nth element from end is "+currNode.data);
//        Deleting nth node
        prevNode.next=currNode.next;
        currNode.next=null;
        size--;
        System.out.println("Removed "+n+"th element from end");
    }
//    Finding nth node from the start
    public String node_at(int i){
        Node currNode=head;
        for(int j=0;j<i-1;j++)currNode=currNode.next;
        return currNode.data;

    }
//    Method to create a list loop
    void create_cycle(int a, int b){
        if(head==null|| head.next==null){
            System.out.println("Can not create circle. Not sufficient elements");
            return;
        }
        Node start=head;
        Node end=head;
        for(int i=0;i<a-1;i++){
            start=start.next;
        }
        for(int i = 0; i< b-1; i++){
            end=end.next;
        }
        if(a<b) end.next=start;
        else start.next=end;
        size_=true;
    }
//    Method to detect a list loop. Floyd's circle searching algorithm/ Hare-Turtle algorithm
    void circle_detector(){
        if(head==null|| head.next==null){
            System.out.println("Circle not present. Not sufficient elements");
            return;
        }

        Node hare=head;
        Node turtle=head;
        while (hare!=null){
            hare=hare.next.next;
            turtle=turtle.next;
            if(hare==turtle){
                System.out.println("The list is in circle");
                listNotCircle=false;
                break;
            }
        }
        if(listNotCircle) System.out.println("The list is not in a circle");
    }
//    Method to break the list loop
    void circle_remover(){

        if (listNotCircle) {
            System.out.println("The list is not t in a circle");
            return;
        }
        Node hare=head;
        Node turtle=head;
        Node meet=head;
        Node turtle2=head;
        Node meetPrev=head;
        int counter=1;
        while (hare.next.next!=null){
            hare=hare.next.next;
            turtle=turtle.next;
            if(hare==turtle){
                meet=turtle;
                break;
            }
            meetPrev=meetPrev.next;
        }
        System.out.println(meet.data);
        System.out.println(meetPrev.data);
        if(!Objects.equals(meet.data, head.data)){do {
            turtle2 = turtle2.next;
            meet = meet.next;
            meetPrev = meetPrev.next;
            counter++;
        } while (meet != turtle2);}
        meetPrev.next=null;
        System.out.println("Looping started at "+meet.data+" whose position is "+counter+"th from start");
        Node currNode =head;
        counter=1;
        if (currNode==null) counter=0;
        while (currNode!=null){
            currNode=currNode.next;
            counter++;
        }
        size_=false;
        size=counter-1;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        link_list test = new link_list();
        while (true){
            System.out.println("Press 1 to add first, press 2 to add last, press 3 to delete first, press 4 to delete last, press 5 to reverse the list ,");
            System.out.println("press 6 to find and delete nth element from end, press 7 to get the node in ith position, press 8 to check palindrome,");
            System.out.println("press 9 to create cycle, press 10 to detect cycle , press 11 to break cycle, 12 to insert element in nth position, ");
            System.out.println("press 13 to replace a node in nth position, press 14 to delete a node in ith position and press 15 to exit");
            int a= sc.nextInt();
            if(a==1){
//                adding node from left
                System.out.println("Enter data");
                String data = sc.next();
                test.addFirst(data);
                test.printList();
            } else if (a==2) {
//                adding rode from right
                System.out.println("Enter data");
                String data = sc.next();
                test.addLast(data);
                test.printList();
            } else if (a==3) {
//                deleting node from left
                System.out.println("Deleting first node");
                test.deleteFirst();
                test.printList();
            } else if (a==4) {
//                deleting node from right
                System.out.println("Deleting last node");
                test.deleteLast();
                test.printList();
            } else if (a==5) {
//                reversing the list
                while(true){
                    System.out.println("Press 1 for iterative method or 2 for recursive method ");
                    int b=sc.nextInt();
                    if(b==1){
//                        iterative reversal
                        System.out.println("Reversing the list in iterative method ");
                        test.reverse_list_iterative();
                        test.printList();
                        break;
                    }
                    else if(b==2){
//                        recursive reversal
                        System.out.println("Reversing the list in recursive method");
                        test.head = test.reverse_list_recursive(test.head);
                        test.printList();
                        break;
                    }
                    else System.out.println("Wrong input.Try again");
                }
            } else if (a==6) {
//                Finding nth node from the end and deleting it
                System.out.println("Enter the position from end");
                int n= sc.nextInt();
                test.nth_node_find_and_delete(n);
                test.printList();
            } else if (a==7) {
//                Finding nth node from the beginning
                System.out.println("Enter the position");
                int n= sc.nextInt();
                System.out.println("The node at "+n+"th position is "+test.node_at(n));
                test.printList();
            } else if (a==8) {
//                Loop palindrome checker
                boolean c=true;
                for (int i=0;i<test.getSize()/2;i++){
                    if(!Objects.equals(test.node_at(i + 1), test.node_at(test.getSize() - i))){
                        c=false;
                        break;
                    }
                }
                if (c) System.out.println("The list is a palindrome");
                else System.out.println("List palindrome ille");
            } else if (a==9) {
//                Creating a loop circle
                System.out.println("Creating cycle. Enter positions of elements you want to join");
                int first=sc.nextInt();
                int last=sc.nextInt();
                test.create_cycle(first,last);
                test.printList();
            } else if (a==10) {
//                Detecting a loop in a list
                test.circle_detector();
            } else if (a==11) {
//                Removing a loop in a list
                test.circle_remover();
                test.printList();
            } else if (a==12) {
//              inserting node at ith position
                System.out.println("Enter the position where you want to enter the element");
                int n = sc.nextInt();
                System.out.println("Enter the element");
                String data=sc.next();
                test.insertElement(n,data);
                test.printList();
            } else if (a==13) {
//                replacing node at ith position
                System.out.println("Enter the position where you want to replace the element");
                int n = sc.nextInt();
                System.out.println("Enter the new element");
                String data=sc.next();
                test.replaceNode(n,data);
                test.printList();
            } else if (a==14) {
//                deleting node at ith position
                System.out.println("Enter the position where you want to delete the element");
                int n = sc.nextInt();
                test.deleteNode(n);
                test.printList();
            }
            if (a==15){
//                Exiting the infinite while loop
                break;
            }
        }
    }
}
