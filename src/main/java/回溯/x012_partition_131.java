package 回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class x012_partition_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        backtrack(result,new LinkedList<>(),charArray,0);
        return result;
    }

    private void backtrack(List<List<String>> result, Deque<String> list, char[] charArray, int index){
        if(index == charArray.length){
            result.add(new ArrayList<>(list));
        }
        for (int i = index; i < charArray.length; i++) {
            String s = new String(charArray, index, i + 1 - index);
            if(isPalindrome(s)){
                list.addLast(s);
                backtrack(result,list,charArray,i+1);
                list.removeLast();
            }
        }
    }

    public boolean isPalindrome(String str){
        int length = str.length();
        int begin = 0,end = length-1;
        while(begin<=end){
            if(str.charAt(begin) != str.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}




