package 动态规划;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 */
public class z007_partition_131 {
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = s.length() - 1; i >= 0; i--) {  // 注意遍历顺序 从下到上，从左到右
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(s,0,result,dp,new LinkedList<>());
        return result;
    }

    private void dfs(String s, int index, List<List<String>> result, boolean[][] dp, Deque<String> list) {
        if(s.length() == index){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                list.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, result, dp, list);
                list.removeLast();
            }
        }

    }
}




