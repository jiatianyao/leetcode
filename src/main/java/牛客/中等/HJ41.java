package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * HJ41 称砝码
 * 题目描述
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 * 注：称重重量包括0
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * 第一行：n --- 砝码数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 *
 * 示例1
 * 输入
 * 复制
 * 2
 * 1 2
 * 2 1
 * 输出
 * 复制
 * 5
 */
public class HJ41 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str ="";
        while((str =  reader.readLine()) !=null){
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            int len = Integer.parseInt(str);
            int[] a = new int[len];
            int[] b = new int[len];
            String[] c = str1.split(" ");
            String[] d = str2.split(" ");
            Set<Integer> set = new HashSet();
            for (int i = 0; i < c.length; i++) {//依次遍历每个砝码
                Integer[] x = new Integer[set.size()];
                set.toArray(x);
                int s1 = Integer.parseInt(c[i]);
                int s2 = Integer.parseInt(d[i]);
                while(s2>0) {//依次遍历砝码数
                    set.add(s1 * s2);//每个砝码与砝码数相乘
                    for (Integer n : x) {//将前一个砝码可能性与当前砝码称重相加
                        set.add(n+s1*s2);
                    }
                    s2--;
                }
            }
            System.out.println(set.size()+1);
        }
    }
}
