import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class convert{
    int[] operator =new int[100];
    int[] operand=new int[100];
    int[] expression=new int[200];
    int[] result = new int[2];
    int top_operand=-1;
    int top_operator=-1;
    int top_result=-1;
    int top_expression=-1;
    void push_operand(int a){
        top_operand++;
        operand[top_operand]=a;
    }
    void push_operator(int a){
        top_operator++;
        operator[top_operator]=a;
    }
    void push_result(int a){
        top_result++;
        result[top_result]=a;
    }
    void push_expression(int a){
        top_expression++;
        expression[top_expression]=a;
    }
    int pop_operand(){
//        System.out.println("The element "+operand[top_operand]+" has been popped");
        return operand[top_operand--];
    }
    int pop_operator(){
//        System.out.println("The element "+operator[top_operator]+" has been popped");
        return operator[top_operator--];
    }
    int pop_result(){
//        System.out.println("The element "+result[top_result]+" has been popped");
        return result[top_result--];
    }

    int pop_expression(){
//        System.out.println("The element "+expression[top_expression]+" has been popped");
        return expression[top_expression--];
    }

    void peek_operand(){
        System.out.println("The element is"+operand[top_operand]);
    }
    void peek_operator(){
        System.out.println("The element is"+operator[top_operator]);
    }
    void peek_result(){
        System.out.println("The element is"+result[top_result]);
    }
    void peek_expression(){
        System.out.println("The element is"+expression[top_expression]);
    }
    int precedence(char a){
        if(a=='*'||a=='/'){return 2;}
        if (a=='+'||a=='-'){return 1;}
        return -1;
    }


    boolean isEmpty_operand(){
        return top_operand==-1;
    }
    boolean isEmpty_operator(){
        return top_operator==-1;
    }
    boolean isEmpty_result(){
        return top_result==-1;
    }

    boolean isEmpty_expression(){
        return top_expression==-1;
    }

    boolean isFull_operand(){
        return top_operand==operand.length;
    }

    boolean isFull_operator(){
        return top_operator==operator.length;
    }

    boolean isFull_result(){
        return top_result==result.length;
    }
    boolean isFull_expression(){
            return top_expression==expression.length;
        }
        String bracket(char p){

            return null;
        }


        public void prefix_expression(String a){
        StringBuilder reverse_string = new StringBuilder();
        reverse_string.append(a);
        reverse_string.reverse();
//        System.out.println(reverse_string);

        for (int i=0; i< reverse_string.length();i++){
//            System.out.println(reverse_string.charAt(i));
            if((reverse_string.charAt(i)>='a')&&(reverse_string.charAt(i)<='z')){
//                System.out.println(reverse_string.charAt(i));
                char s=reverse_string.charAt(i);
                push_expression(s);
                continue;
//                System.out.println(ascii);

            }
            if((reverse_string.charAt(i)=='+')||(reverse_string.charAt(i)=='-')||(reverse_string.charAt(i)=='*')||(reverse_string.charAt(i)=='/')){
//                System.out.println(reverse_string.charAt(i));
                if(isEmpty_operator()){
                    char s=reverse_string.charAt(i);
//                    System.out.println(s);
                    push_operator(s);
                }
                else {char asciiToChar = (char) operator[top_operator];
                    if(precedence(reverse_string.charAt(i))>=precedence(asciiToChar)){
                        char s=reverse_string.charAt(i);
                        push_operator(s);
                    }
                    else {
                            push_expression(pop_operator());
                            char s=reverse_string.charAt(i);
                            push_operator(s);

                    }
                }
            }

        }
        for (int i=top_operator;i>-1;i--){
            push_expression(operator[i]);
        }
        for (int i=top_expression;i>-1;i--){
            char asciiToChar = (char) expression[i];
            System.out.print(asciiToChar);
        }
    }
    void postfix(String a){

    }
}
public class inf_to_post {
    public static void main(String[] args) {
        String infix;
        System.out.println("Enter your expression in infix");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            infix = input.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        convert c=new convert();
        c.prefix_expression(infix);
//        c.peek_operator();
//        c.peek_operand();
//        System.out.println(infix);
    }
}
