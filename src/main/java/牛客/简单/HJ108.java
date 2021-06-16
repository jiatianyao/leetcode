package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 5 7
 * 输出
 * 35
 */
public class HJ108 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);

            System.out.println((m * n) / gcd(m, n));
        }

    }

    /**
     * 求公约数
     */
    public static int gcd(int a,int b){
        if(b==0) return a;
        System.out.println(a%b);
        return gcd(b,a% b);
    }
}
