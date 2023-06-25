import java.util.*;
// defining class
class prefixEvaluation{
    double stack[]=new double[50];
    int top=-1;
    String exp = new String();
//function to take inputs
void accept(){
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter the prefix expression");
    exp=sc.nextLine();
}
//function to push an element into the stack
void push(double c){
    stack[++top]=c;
}
//function to pop an element
double pop(){
    return stack[top--];
}
//function to check whether the character is an operator or not
boolean is_operand(char c){
    return c >= '0' && c <= '9';
}
//function to evaluate the expression
void evaluate(){
    int j;
    double a,b;
    for(j=exp.length()-1;j>=0;j--){
        if(is_operand(exp.charAt(j)))
            push(exp.charAt(j)-'0');
        else {
            a=stack[top];
            pop();
            b=stack[top];
            pop();
            switch (exp.charAt(j)){
                case '+':
                    push(a+b);
                    break;
                case '-':
                    push(a-b);
                    break;
                case '*':
                    push(a*b);
                    break;
                case '/':
                    push(a/b);
                    break;
            }
        }
    }
    System.out.println(stack[top]);
}

}
public class lab_prefix_evaluation {
    public static void main(String[] args) {
            //creating an object
        prefixEvaluation p= new prefixEvaluation();
        p.accept();
        p.evaluate();
    }
}
