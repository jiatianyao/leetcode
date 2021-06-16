package 牛客.中等;


/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
public class HJ8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int num = Integer.parseInt(str);
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>((o1, o2) -> o1-o2);
        while(num>0){
            num--;
            String str2 = reader.readLine();
            String[] s = str2.split(" ");
            Integer key = Integer.parseInt(s[0]);
            Integer value = Integer.parseInt(s[1]);
            Integer orDefault = map.getOrDefault(key, 0);
            map.put(key, orDefault+value);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }

}
