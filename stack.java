import java.util.*;
class My_Stack{
    int stack1[]=new int[5];
    int top=0;
    public void push(int data){
        stack1[top]=data;
        top++;
    }
    public void pop(){
        top--;
        stack1[top]=0;

    }
    void show(){
        for (int i=0;i<5;i++){
            System.out.print(stack1[i]+" ");
        }
    }
    int peek(){
        int data;
        data=stack1[top-1];
        return data;
    }

}
public class stack {
    public static void main(String[] args) {
        My_Stack num = new My_Stack();
        num.push(6);
        num.push(10);
        num.push(45234);
        num.show();
        System.out.println();
        num.pop();
        num.show();
        System.out.println();
        System.out.println(num.peek());
    }
}
