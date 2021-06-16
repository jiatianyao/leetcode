package 字符串;

public class leetcode5 {

    public static void main(String[] args) {
        System.out.println(longestPalidromeViolence("babad"));
        System.out.println(longestPalidromeViolenceDP("ABBA"));
        System.out.println(longestPalindrome("ABBA"));
    }


    //**第一种解法**//
    //暴力解法最长回文
    public static String longestPalidromeViolence(String s){
        int len = s.length();
        if(len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int lenSub = j-i+1;
                if( lenSub > maxLen && validPalidromic(charArray,i,j)){
                    begin = i;
                    maxLen = lenSub;
                }
            }

        }
        return s.substring(begin,begin+maxLen);
    }


    private static boolean validPalidromic(char[] charArray, int i, int j) {
        while (i<j){
            if(charArray[i] != charArray[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    //**第二种解法**//
    /**中间扩散法**/
    public static String longestPalidromeViolenceMiddle(String s){
        int len = s.length();
        if(len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len-1; i++) {
            int oddLen = expandAroundCenter(charArray,i,i);
            int evenLen = expandAroundCenter(charArray,i,i+1);
            int curMaxLen = Math.max(oddLen,evenLen);
            if(curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (maxLen -1) /2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }


    /**中间扩散法**/
    public static int expandAroundCenter(char[] charArray,int left,int right){
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i>=0 && j<len){
            if(charArray[i]==charArray[j]){
                i--;
                j++;
            }else{
                break;
            }
        }
        return j-i-1;

    }



    //**第三种解法**//
    /**
     * 定义状态：dp[i][j] 表示子串s[i...j]是否为回文子串
     * 定义状态方程：dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
     * 边界条件：j-1 + (i+1) +1 < 2 整理为 j - i < 3  即 j-1+1 < 4;  (例如 长度为2或者3的子串不需要检查是否回文)
     */
    public static String longestPalidromeViolenceDP(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        boolean [][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        //左下角先填值
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {

                if(charArray[i]!=charArray[j]){
                    dp[i][j] =false;
                }else{
                    if(j-i < 3){
                        dp[i][j] =true;
                    }else{
                        dp[i][j] =  dp[i+1][j-1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if(dp[i][j] && j -i + 1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
