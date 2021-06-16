package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月25日00:21:30\
 * 2021年4月25日00:31:32
 * 走方格的方案数
 * 题目描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 本题含有多组样例输入。
 * 输入描述:
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 *
 * 输出描述:
 * 每组样例输出一行结果
 *
 * 示例1
 * 输入
 * 2 2
 * 1 2
 * 输出
 * 6
 * 3
 */
public class HJ91_easy {

    private static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            sum = 0;
            String[] s = str1.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            dp(m,n,0,0);
            System.out.println(sum);

        }
    }

    public static void dp(int m,int n,int i,int j){
        if(i==m && n==j) {
            sum++;
            return;
        }
        if(i>m || j>n) return;
        dp(m,n,i+1,j);
        dp(m,n,i,j+1);
    }
}
