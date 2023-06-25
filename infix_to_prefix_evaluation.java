//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Convert{
//    int top=-1;
//    int[] operation=new int[2];
//    int[] bracket=new int[100];
//
//    private boolean isFull(){
//        return top==1;
//    }
//    private boolean isEmpty(){
//        return top==-1;
//    }
//    private void push(int a){
//        operation[++top]=a;
//    }
//    private void pop(){
//        top--;
//    }
//    private void peek(){
//        System.out.println(operation[top]);
//    }
//    private int precedence(char ch){
//        switch(ch){
//            case '*':
//            case '/':
//            case '%': return 2;
//            case '+':
//            case '-': return 1;
//        }
//        return 0;
//    }
//    private void bracket(String s){
//        evaluate(0,s);
//    }
//    void evaluate(int a,String s){
//        if( a==1){
//            String rev="";
//           for(int i=0;i<s.length();i++){
//               rev=s.charAt(i)+rev;
//           }
//           s=rev;
//        }
//        //System.out.println(s);
//        for(int i=0;i<s.length();i++){
//            if (!isFull()){
//                if ((s.charAt(i)=='+')||(s.charAt(i)=='-')||(s.charAt(i)=='*')||(s.charAt(i)=='/')||(s.charAt(i)=='%')){
////                 if()
//                }
//                if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
//                    push((int)s.charAt(i));
//                    continue;
//                }
//                if
//            }
//        }
//
//    }
//
//}
//public class infix_to_prefix_evaluation {
//    public static void main(String[] args) {
//        String infix;
//        System.out.println("Enter your expression in infix");
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            infix = input.readLine();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Convert c=new Convert();
//        c.evaluate(1,infix);
//    }
//}
