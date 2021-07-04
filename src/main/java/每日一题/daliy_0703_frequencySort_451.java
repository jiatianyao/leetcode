package 每日一题;

import java.util.*;

public class daliy_0703_frequencySort_451 {


    public String frequencySort(String s) {
        int length = s.length();
        List<Chars> chars = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            Integer times = map.getOrDefault(c, 0);
            map.put(c,++times);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            chars.add(new Chars(entry.getKey(),entry.getValue()));
        }
        chars.sort((o1, o2) -> o2.times- o1.times);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            Integer times = chars.get(i).getTimes();
            while(times>0) {
                sb.append(chars.get(i).getChars());
                times--;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        daliy_0703_frequencySort_451 demo = new daliy_0703_frequencySort_451();
        String tree = demo.frequencySort("tree");
        System.out.println(tree);
    }
}

class Chars {
    Character chars;
    Integer times;

    public Chars(Character chars, Integer times) {
        this.chars = chars;
        this.times = times;
    }

    public Character getChars() {
        return chars;
    }

    public Integer getTimes() {
        return times;
    }
}
