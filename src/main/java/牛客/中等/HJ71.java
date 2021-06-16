package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * 返回匹配的结果，正确输出true，错误输出false
 * 本题含有多组样例输入！
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 示例1
 * 输入
 * te?t*.*
 * txt12.xls
 * 输出
 * false
 */
public class HJ71 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 =reader.readLine();
            System.out.println(isMatch(str2,str1));
        }
    }

    public static  boolean isMatch(String s, String p) {

        if(s.length() == 0 && p.length() == 0)return true;
        if(s.length()!= 0 && p.length() == 0) return false;
        boolean [][] dp = new boolean [s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 2; j <= p.length(); j++){
            if(p.charAt(j-1) == '*' && dp[0][j-2]){
                dp[0][j] = true;
            }
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                char a = s.charAt(i-1), b = p.charAt(j-1);
                if(a == b || b == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(b == '*'){
                    if(j>=2){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }

                }

                else dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}


