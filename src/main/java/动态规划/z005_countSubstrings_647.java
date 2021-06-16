package 动态规划;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class z005_countSubstrings_647 {
    //动态方程：s.charAt(i) 与 s.charAt(j) 不相同：dp数组为false
    // 相同：需要继续判断
    // case 1： i==j 相同字符串 eg:a 为回文
    // case 2 : i与j 相差一个字符串 eg:aba 为回文
    // case 3 ： i与j相差超过一个字符串，需要dp[i+1][j-1] 为true才为true
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {  // 注意遍历顺序 从下到上，从左到右
            for (int j = i; j < s.length(); j++) {

               if(s.charAt(i) == s.charAt(j)){

                   if(j-i<=1){ //case 1,2
                       dp[i][j] = true;
                       result++;
                   }else if(dp[i+1][j-1]){
                       dp[i][j] = true;
                       result++;
                   }
               }else{
                  dp[i][j] = false;
               }

            }
        }
        return result;
    }

    //从左和左下角到右上角遍历方式
    public int countSubstrings2(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                System.out.println("i=="+i+";j=="+j);
                if(s.charAt(i) == s.charAt(j)){

                    if(j-i<=1){ //case 1,2
                        dp[i][j] = true;
                        result++;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                        result++;
                    }
                }else{
                    dp[i][j] = false;
                }

            }
        }
        return result;
    }

    //降纬
    public int countSubstrings3(String s) {
        boolean dp[] = new boolean[s.length()];
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {

                if(i==j){
                    dp[i] = true;
                    result++;
                }else if(j-i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i] = true;
                    result++;
                }else if(j-i > 1 && s.charAt(i) == s.charAt(j) && dp[i+1]){
                    dp[i]= true;
                    result++;
                }else{
                    dp[i]= false;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        z005_countSubstrings_647 demo = new z005_countSubstrings_647();
        demo.countSubstrings2("aabaca");
    }

}
