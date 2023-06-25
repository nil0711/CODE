package practice_;

import java.util.*;

public class spilled_milk {
    public static void main(String[] args) {
        Map<Character, Integer> freq = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Input your string: ");
        String input = sc.nextLine();

        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println(freq);


        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(freq.entrySet());
        Collections.sort(entryList, (e1, e2) -> {
            int freqComp = e1.getValue().compareTo(e2.getValue());
            return (freqComp != 0) ? freqComp : e1.getKey().compareTo(e2.getKey());
        });
        System.out.println(entryList);


        for (Map.Entry<Character, Integer> entry : entryList){
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                System.out.print(c);
            }
        }
    }
}

