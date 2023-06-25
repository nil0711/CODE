import java.util.Scanner;

class Stack_lab{
    static int size =100;
    int top=-1;
    int a[]=new int[size];
    boolean isEmpty(){
        return (top<0);
    }
    boolean push(int x){
        if(top>=(size -1)){
            System.out.println("Stack is full");
            return false;
        }
        else{
            a[++top]=x;
            System.out.println("The number "+x+" is pushed into stack");
            return true;
        }
    }
    int pop(){
        if(top<0){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            int x=a[top--];
            return x;
        }
    }
    int peek(){
        if(top<0){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            int x=a[top];
            return x;
        }
    }
    void print(){
        for(int i=top;i>=0;i--){
            System.out.print(a[top-i]+" ");
        }
    }
}
public class stack_lab_exercise {
    public static void main(String[] args) {
        Stack_lab s=new Stack_lab();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Enter 1 to push, 2 to pop, 3 to peek, 4 to print, 5 to exit");
            int a= sc.nextInt();
            if(a==1){
                System.out.println("Enter number to push");
                int a1= sc.nextInt();
                s.push(a1);
            }
            else if(a==2){
                System.out.println(s.pop() + " was popped from stack");
            }
            else if(a==3){
                System.out.println("Top element is :" + s.peek());
            }
            else if (a==4){
                s.print();
                System.out.println();
            }
            else if (a==5){
                break;
            }

            else {
                System.out.println("Wrong option try again.");
            }
        }
    }
}
