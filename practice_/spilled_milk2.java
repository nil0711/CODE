package practice_;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class spilled_milk2 {

    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> freq_list= new ArrayList<>();
        ArrayList <Character> char_list = new ArrayList<>();

        System.out.println("Input string");
        input=sc.nextLine();

        for (char c : input.toCharArray()){
            if(char_list.contains(c)){
                freq_list.set(char_list.indexOf(c),freq_list.get(char_list.indexOf(c))+1);
                continue;
            }
            char_list.add(c);
            freq_list.add(1);
        }
        System.out.println("Unsorted :");
        System.out.println(char_list);
        System.out.println(freq_list);


        for(int i = 0; i < freq_list.size();i++){
            for (int j = i; j < freq_list.size();j++ ){
                if(freq_list.get(i)>=freq_list.get(j)){
                    int temp = freq_list.get(i);
                    freq_list.set(i, freq_list.get(j));
                    freq_list.set(j,temp);
                    char temp1 = char_list.get(i);
                    char_list.set(i,char_list.get(j));
                    char_list.set(j,temp1);
                }
            }
        }
        System.out.println("Frequency sorted :");
        System.out.println(char_list);
        System.out.println(freq_list);


        for(int i = 0; i < freq_list.size();i++){
            for (int j = i; j < freq_list.size();j++ ){
                if(Objects.equals(freq_list.get(i), freq_list.get(j))){
                    if(char_list.get(i)>=char_list.get(j)){
                        char temp1 = char_list.get(i);
                        char_list.set(i,char_list.get(j));
                        char_list.set(j,temp1);
                    }
                }
            }
        }
        System.out.println("Alphabetically sorted");
        System.out.println(char_list);
        System.out.println(freq_list);


        System.out.println("Output String");
        for (int i = 0 ; i < freq_list.size(); i++){
            for (int j=0; j< freq_list.get(i);j++){
                System.out.print(char_list.get(i));
            }
        }
    }
}
