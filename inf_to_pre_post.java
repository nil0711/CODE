import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class convert {
    int[] operator = new int[100];
    int[] operand = new int[100];
    int[] expression = new int[200];
    int[] result = new int[2];
    int top_operand = -1;
    int top_operator = -1;
    int top_result = -1;
    int top_expression = -1;

    void push_operand(int a) {
        top_operand++;
        operand[top_operand] = a;
    }

    void push_operator(int a) {
        top_operator++;
        operator[top_operator] = a;
    }

    void push_result(int a) {
        top_result++;
        result[top_result] = a;
    }

    void push_expression(int a) {
        top_expression++;
        expression[top_expression] = a;
    }

    int pop_operand() {
//        System.out.println("The element "+operand[top_operand]+" has been popped");
        return operand[top_operand--];
    }

    int pop_operator() {
//        System.out.println("The element "+operator[top_operator]+" has been popped");
        return operator[top_operator--];
    }

    int pop_result() {
//        System.out.println("The element "+result[top_result]+" has been popped");
        return result[top_result--];
    }

    int pop_expression() {
//        System.out.println("The element "+expression[top_expression]+" has been popped");
        return expression[top_expression--];
    }

    void peek_operand() {
        System.out.println("The element is" + operand[top_operand]);
    }

    void peek_operator() {
        System.out.println("The element is" + operator[top_operator]);
    }

    void peek_result() {
        System.out.println("The element is" + result[top_result]);
    }

    void peek_expression() {
        System.out.println("The element is" + expression[top_expression]);
    }

    int precedence(char a) {
        switch (a) {
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }


    boolean isEmpty_operand() {
        return top_operand == -1;
    }

    boolean isEmpty_operator() {
        return top_operator == -1;
    }

    boolean isEmpty_result() {
        return top_result == -1;
    }

    boolean isEmpty_expression() {
        return top_expression == -1;
    }

    boolean isFull_operand() {
        return top_operand == operand.length;
    }

    boolean isFull_operator() {
        return top_operator == operator.length;
    }

    boolean isFull_result() {
        return top_result == result.length;
    }

    boolean isFull_expression() {
        return top_expression == expression.length;
    }


    public void prefix_expression(String a) {

            String rev = "";
            for (int i = 0; i < a.length(); i++) {
                rev = a.charAt(i) + rev;
            }
            a = rev;
        //        System.out.println(a);

        for (int i = 0; i < a.length(); i++) {
//            System.out.println(a.charAt(i));
            if ((a.charAt(i) >= 'a') && (a.charAt(i) <= 'z')) {
//                System.out.println(a.charAt(i));
                char s = a.charAt(i);
                push_expression(s);
                continue;
//                System.out.println(ascii);

            }
            if ((a.charAt(i) == '+') || (a.charAt(i) == '-') || (a.charAt(i) == '*') || (a.charAt(i) == '/') || (a.charAt(i) == '%')) {
//                System.out.println(a.charAt(i));
                if (isEmpty_operator()) {
                    char s = a.charAt(i);
//                    System.out.println(s);
                    push_operator(s);
                } else {
                    char asciiToChar = (char) operator[top_operator];
                    if (precedence(a.charAt(i)) >= precedence(asciiToChar)) {
                        char s = a.charAt(i);
                        push_operator(s);
                    } else {
                        push_expression(pop_operator());
                        char s = a.charAt(i);
                        push_operator(s);

                    }
                }
            }
            if ((a.charAt(i) == '(')) {
                int count = 0;
                int position = 0;
                for (int j = i + 1; j < a.length(); j++) {
                    if ((a.charAt(j) == '(')) {
                        count++;
                    }
                }
                System.out.println(count);
                for (int j = i + 1; j < a.length(); j++) {
                    if ((a.charAt(j) == ')')) {
                        if (count == 0) position = j;
                        else count--;
                    }

                }
                System.out.println(position);
                String substr = a.substring(i + 1, position);
               prefix_expression(substr);

            }

        }
        for (int i = top_operator; i > -1; i--) {
            push_expression(operator[i]);
        }
        for (int i = top_expression; i > -1; i--) {
            char asciiToChar = (char) expression[i];
            System.out.print(asciiToChar);
        }
        int top_operator = -1;
        int top_expression = -1;

    }
    public void postfix_expression(String a){
        for (int i = 0; i < a.length(); i++) {
//            System.out.println(a.charAt(i));
            if ((a.charAt(i) >= 'a') && (a.charAt(i) <= 'z')) {
//                System.out.println(a.charAt(i));
                char s = a.charAt(i);
                push_expression(s);
                continue;
//                System.out.println(ascii);

            }
            if ((a.charAt(i) == '+') || (a.charAt(i) == '-') || (a.charAt(i) == '*') || (a.charAt(i) == '/') || (a.charAt(i) == '%')) {
//                System.out.println(a.charAt(i));
                if (isEmpty_operator()) {
                    char s = a.charAt(i);
//                    System.out.println(s);
                    push_operator(s);
                } else {
                    char asciiToChar = (char) operator[top_operator];
                    if (precedence(a.charAt(i)) >= precedence(asciiToChar)) {
                        char s = a.charAt(i);
                        push_operator(s);
                    } else {
                        push_expression(pop_operator());
                        char s = a.charAt(i);
                        push_operator(s);

                    }
                }
            }
            if ((a.charAt(i) == '(')) {
                int count = 0;
                int position = 0;
                for (int j = i + 1; j < a.length(); j++) {
                    if ((a.charAt(j) == '(')) {
                        count++;
                    }
                }
                System.out.println(count);
                for (int j = i + 1; j < a.length(); j++) {
                    if ((a.charAt(j) == ')')) {
                        if (count == 0) position = j;
                        else count--;
                    }

                }
                System.out.println(position);
                String substr = a.substring(i + 1, position);
                postfix_expression(substr);

            }

        }
        for (int i = top_operator; i > -1; i--) {
            push_expression(operator[i]);
        }
        for (int i = 0; i <=top_expression; i++) {
            char asciiToChar = (char) expression[i];
            System.out.print(asciiToChar);
        }

        int top_operator = -1;
        int top_expression = -1;

    }

}
public class inf_to_pre_post {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String infix;
        System.out.println("Enter your expression in infix");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            infix = input.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        convert c=new convert();
        System.out.println("prefix:");
        c.prefix_expression(infix);
        System.out.println();
//        System.out.println("postfix:");
//        c.postfix_expression(infix);

    }
}
