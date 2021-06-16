package 动态规划;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 */
public class z006_longestPalindrome_5 {

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 0;
        int begin =0;
        for (int i = s.length() - 1; i >= 0; i--) {  // 注意遍历顺序 从下到上，从左到右
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                    if(dp[i][j] && maxLength<=j-i+1){
                        maxLength =j-i+1;
                        begin = i;
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return  s.substring(begin, begin + maxLength);
    }


    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        //dp[i][j] = (s[i] = s[j]) && dp[i+1][j-1]
        //边界条件：j-1 - (i+1) +1 < 2 没有意义  整理得 j -i < 3
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int begin =0;
        for (int j =1; j<length; j++) {  // 一列一列遍历，再一行一行遍历
            for (int i = 0; i<j; i++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i < 3){
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                    if(dp[i][j] && maxLength < j-i+1){
                        maxLength =j-i+1;
                        begin = i;
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return  s.substring(begin, begin + maxLength);
    }

    public static void main(String[] args) {
        z006_longestPalindrome_5 demo= new z006_longestPalindrome_5();
        demo.longestPalindrome2("ac");
    }
}
