package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * hj61 放苹果
 * 题目描述
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 *
 * 推到过程
 * 7个苹果放入3个盘子
 * 7 0 0       此处相当于 7个苹果放2个盘子
 * 6 1 0
 * 5 2 0
 * 4 3 0
 * ---------->
 * 5 1 1     此处每个数字-1 变成   4 0 0   即为4个苹果放3个盘子算法
 * 4 2 1                          3 1 0
 * 3 2 2                          2 1 1
 * 3 3 1                          2 2 0
 *
 * f(7,3) = f(7,2) + f(4,3)
 * 推导出公式
 * f(n,m) = f(n,m-1) + f(n-m,m)
 */
//2021年4月10日22:48:37
public class HJ61 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = reader.readLine())!=null ){
            String[] s1 = s.split(" ");
            int m = Integer.parseInt(s1[0]);
            int n = Integer.parseInt(s1[1]);
            int cal = cal(m, n);
            System.out.println(cal);
        }

    }

    public static int cal(int m,int n){
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        return cal(m,n-1)+cal(m-n,n);
    }
}
