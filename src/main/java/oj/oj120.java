package oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
 * 提交记录
 * 题解
 * 120. 找n个数的最小值
 * 题目描述
 * ​ 给出  个整数，找出其中最小的值。
 *
 * 输入格式
 * ​ 输入第一行一个整数 ，表示整数的数量。
 * （
 * ）
 *
 * ​ 输入第二行为  个整数  。
 * （
 * ）
 *
 * 输出格式
 * ​ 输出个整数中最小值。
 *
 * 样例输入
 * 8
 * 1 9 2 6 0 8 1 7
 * 样例输出
 * 0
 */
//69017506
public class oj120 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        while ((str1 = reader.readLine()) != null) {
            Integer.parseInt(str1);
            String str2 = reader.readLine();
            String[] s = str2.split(" ");
            int[] ints = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ints);
            System.out.println(ints[0]);
        }
    }


}
