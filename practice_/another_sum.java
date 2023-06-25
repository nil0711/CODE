package practice_;

import java.util.Scanner;
import java.util.Stack;

public class another_sum {
    public static void main(String[] args) {
        Stack <Character> list = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input String");
        String input = sc.nextLine();
        for (char ch : input.toCharArray()) {
            list.push(ch);
        }
        System.out.println(list);
        String output = "";
        int count = list.size();
        for(int i =0; i<count;i++){
            output= output + list.pop();
            System.out.println(output);
        }
    }
}
