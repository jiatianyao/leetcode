package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
public class x014_generateParenthesis_22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,0,0,new StringBuffer());
        return result;
    }

    public void backtrack(int n,int left,int right,StringBuffer stringBuffer){
        if(stringBuffer.length() == n * 2){
            result.add(new StringBuffer(stringBuffer).toString());
        }
        if(left < n){
            stringBuffer.append("(");
            backtrack(n,left+1,right,stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if(right < left){
            stringBuffer.append(")");
            backtrack(n,left,right+1,stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }

    public static void main(String[] args) {
        x014_generateParenthesis_22 demo = new x014_generateParenthesis_22();
        demo.generateParenthesis(3);
    }
}
