package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ56 完全数
 * 题目描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s
 *
 * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 *
 *
 * 本题输入含有多组样例。
 */
public class HJ56 {
    public static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) !=null){
            int n = Integer.parseInt(str);
            int i = 2;
            res = 0;
            while(i<=n){
                isperfact(i);
//                boolean aaa = aaa(i);
//                System.out.println(i+"----"+aaa);
                i++;
            }
            System.out.println(res);
        }
    }

    public static void isperfact(int n){
        int i = n/2;
        int s =0;
        while(i>1){
            if(n%i ==0 ){
                s = s+i;
            }
            i--;
        }
        if(s+1==n){
            res++;
        }
    }

}
