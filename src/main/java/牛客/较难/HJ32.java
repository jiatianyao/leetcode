package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ32 字符串运用密码截取
 * 参考字符串-leetcode5
 * 题目描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
 * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,
 * 123321->51233214。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 * Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入一个字符串
 * 输出描述:
 * 返回有效密码串的最大长度
 *
 * 示例1
 * 输入
 * ABBA
 * 输出
 * 4
 */
public class HJ32 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int maxLen = 0;
            int begin = 0;
            char[] chars = str1.toCharArray();
            int len = chars.length;
            boolean[][] dp = new boolean[len][len]; //定义状态
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;//单个字符为true
            }

            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if(chars[i]!=chars[j]){
                        dp[i][j] =false;
                    }else{
                        if(j-i<3){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] =  dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j] && j -i + 1>maxLen){
                        maxLen = j-i +1;
                        begin = i;
                    }
                }
            }
            System.out.println(str1.substring(begin,begin+maxLen).length());
        }
    }
}


