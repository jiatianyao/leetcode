package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ52 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 = reader.readLine();
            int ic = 1;
            int dc = 1;
            int rc = 1;
            int cost = strEditCost(str1, str2, ic, dc, rc);
            System.out.println(cost);
        }
    }

    /* 字符串之间的距离，编辑距离，将strA编辑成strB所需的最小代价
     * 编辑操作包括插入一个字符、删除一个字符、替换一个字符
     * 分别对应的代价是ic、dc、rc，insert cost、delete cost、replace cost
     * strA[x-1]代表strA的第x个字符，注意下标是从0开始的,strA[y-1]代表strA的第y个字符
     * 定义一个代价矩阵为(N+1)*(M+1)，M N 表示strA strB的长度
     * dp[x][y]表示strA的前x个字符串编辑成 strB的前y个字符所花费的代价
     * dp[x][y]是下面几种值的最小值：
     * 1、dp[x][y] = dp[x-1][y] + dc
     * dp[x-1][y]将strA的前x-1个字符编辑成strB的前y个字符的代价已知，
     * 那么将将strA的前x个字符编辑成strB的前y个字符的代价dp[x][y]就是dp[x-1][y] + dc
     * 相当于strA的前x-1个字符编辑成strB的前y个字符，现在变成了strA的前x个字符，增加了一个字符，要加上删除代价
     * 2、dp[x][y] = dp[x][y-1] + ic
     * dp[x][y-1]将strA的前x个字符编辑成strB的前y-1个字符的代价已知，
     * 现在变为strB的前y个字符，相应的在strA前x个操作代价的基础上插入一个字符
     * 3、dp[x][y] = dp[x-1][y-1]
     * dp[x-1][y-1]将strA的前x-1个字符编辑成strB的前y-1个字符的代价已知，
     * strA的第x个字符和strB的第y个字符相同，strA[x-1] == strB[y-1]，没有引入操作
     * 4、dp[x][y] = dp[x-1][y-1] + rc
     * strA的第x个字符和strB的第y个字符不相同，strA[x-1] ！= strB[y-1]，
     * 在strA的前x-1个字符编辑成strB的前y-1个字符的代价已知的情况下，
     * 计算在strA的前x字符编辑成strB的前y个字符的代价需要加上替换一个字符的代价
     * */
    /*ic 插入，dc删除，rc替换*/
    private static int strEditCost(String str1, String str2, int ic, int dc, int rc) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][]dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) dp[i][0] = i*dc;
        for (int i = 1; i <= len2; i++) dp[0][i] = i*ic;
        for (int x = 1; x <= len1; x++) {
            for (int y = 1; y <= len2; y++){
                int cost1 = dp[x-1][y] + dc;
                int cost2 = dp[x][y-1] + ic;
                int cost3= 0;
                if(str1.charAt(x-1) == str2.charAt(y-1)){
                    cost3 = dp[x-1][y-1];
                }else{
                    cost3 = dp[x-1][y-1]+rc;
                }
                dp[x][y] =Math.min(cost1,cost2);
                dp[x][y] =Math.min(dp[x][y] ,cost3);
            }
        }
        return  dp[len1][len2];
    }
}
