package 每日一题;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 *
 */
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
