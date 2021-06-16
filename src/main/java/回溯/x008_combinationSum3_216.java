package 回溯;

import java.util.*;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class x008_combinationSum3_216 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        backtrack(k,n,new LinkedList<>(),1);
        return res;
    }

    public void backtrack(int k, int n, Deque<Integer> list,int index){
        if(k < 0){
            return;
        }

        if(n == 0 && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if(list.size() > k) return;

            list.addLast(i);
            backtrack(k,n-i,list,i+1);
            list.removeLast();

        }
    }

    public static void main(String[] args) {
        x008_combinationSum3_216 x008_combinationSum3_216 = new x008_combinationSum3_216();
        x008_combinationSum3_216.combinationSum3(3,7);
    }
}
