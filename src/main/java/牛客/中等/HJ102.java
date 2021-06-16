package 牛客.中等;

import java.util.*;

/**
 * 题目描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，
 * 则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 *
 * 示例1
 * 输入
 * aaddccdc
 * 1b1bbbbbbbbb
 * 输出
 * cda
 * b1
 */
public class HJ102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            PriorityQueue<Point2> pq = new PriorityQueue<>();
            /*
            PriorityQueue<Point> pq = new PriorityQueue<>((x, y) -> -128*(x.number - y.number) + (int)(x.c - y.c));
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Point p = new Point(entry.getKey(), entry.getValue());
                pq.offer(p);
            }
            */
            map.forEach((k, v) -> pq.offer(new Point2(k, v)));
            StringBuilder res = new StringBuilder();
            while (!pq.isEmpty()) {
                res.append(pq.poll().c);
            }
            System.out.println(res.toString());
        }
    }
}
class Point2 implements Comparable<Point2>{
    public char c;
    public int number;
    Point2(char c, int number){
        this.c = c;
        this.number = number;
    }
    @Override
    public int compareTo(Point2 p2){
        if (p2.number != this.number){
            return p2.number - this.number;
        }else {
            return (int)(this.c - p2.c);
        }
    }
}
