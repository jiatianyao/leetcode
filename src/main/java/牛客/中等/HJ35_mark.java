package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ35 蛇形矩阵
 * 题目描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * 请注意本题含有多组样例输入。
 * 输入描述:
 * 输入正整数N（N不大于100）
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 *
 * 示例1
 * 输入
 * 4
 * 输出
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */

public class HJ35_mark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int n = Integer.parseInt(str1);
            for (int i = 0; i < n; i++) {
                for (int j = (i + 1); j <= n; j++) {
                    System.out.print(((j*j + j) / 2) - i + " ");
                }
                System.out.println("");
            }
        }
    }
}
