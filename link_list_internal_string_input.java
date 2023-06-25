import java.util.Scanner;

class linked_list {
    Node head = null;
    int size = 0;

    //    Creating TreeTraversal.Node user defined data structure
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    //      adding first element
    void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    //      adding last element
    void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }

    //    adding element in the ith position
    void insertElement(int n, String data) {
        if (n > size) {
            System.out.println("Position does not exist");
            return;
        }
        Node newNode = new Node(data);
        Node currNode = head;
        if (n == 1) {
            addFirst(data);
            size++;
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    }

    //    printList
    void printList() {
        int i = 0;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
            i++;
        }
        System.out.println("NULL");

        System.out.println("The size of list is " + size);
    }

    //        delete first
    void deleteFirst() {
        if (head == null) {
            size = 0;
            return;
        }
        head = head.next;
        size--;
    }

    //    delete last
    void deleteLast() {
        if (head == null) {
            size = 0;
            return;
        }
        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }
        Node secondLast = head;
        Node last = head.next;
        while (last.next != null) {
            last = last.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        size--;
    }

    //    deleting a node in nth position
    void deleteNode(int n) {
        if (n > size) {
            System.out.println("Position does not exist");
            return;
        }
        Node currNode = head;
        if (n == 1) {
            deleteFirst();
            size--;
            return;
        }
        if (n != 1 && n == size) {
            deleteLast();
            size--;
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
        size--;
    }

    //    replacing a node in nth position
    void replaceNode(int n, String data) {
        if (n > size) {
            System.out.println("Position does not exist");
            return;
        }
        Node newNode = new Node(data);
        Node currNode = head;
        if (n == 1) {
            head = newNode;
            return;
        }
        if (n != 1 && n == size) {
            deleteLast();
            addLast(data);
            return;
        }
    }
}
    public class link_list_internal_string_input {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            link_list string_list=new link_list();

            while (true){
                System.out.println("Press 1 to add first, press 2 to add last, press 3 to add in the middle, 4 to delete from start, ");
                System.out.println("5 to delete from last, 6 to delete at any given position, 7 to update any node in the list, 8 to exit");
                int a= sc.nextInt();
                if(a==1){
//                adding node from left
                    System.out.println("Enter data");
                    String data = sc.next();
                    string_list.addFirst(data);
                    string_list.printList();
                } else if (a==2) {
//                adding rode from right
                    System.out.println("Enter data");
                    String data = sc.next();
                    string_list.addLast(data);
                    string_list.printList();
                } else if (a==3) {
//                adding in the middle
                    System.out.println("Enter data");
                    String data = sc.next();
                    System.out.println("Enter the position where you want to add");
                    int n=sc.nextInt();
                    string_list.insertElement(n,data);
                    string_list.printList();
                } else if (a==4) {
//                deleting from the left
                    System.out.println("Deleting the first node");
                    string_list.deleteFirst();
                    string_list.printList();
                } else if (a==5) {
//                deleting the last node
                    System.out.println("Deleting the last node");
                    string_list.deleteLast();
                    string_list.printList();
                } else if (a==6) {
//                deleting node in middle
                    System.out.println("Enter the position where you want to delete the element");
                    int n = sc.nextInt();
                    string_list.deleteNode(n);
                    string_list.printList();
                } else if(a==7){
//                updating node in middle
                    System.out.println("Enter the position where you want to replace the element");
                    int n = sc.nextInt();
                    System.out.println("Enter the new element");
                    String data=sc.next();
                    string_list.replaceNode(n,data);
                    string_list.printList();
                }
                if(a==8)break;
            }
        }
    }

