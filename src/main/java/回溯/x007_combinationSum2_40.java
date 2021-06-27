package 回溯;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class x007_combinationSum2_40 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,new LinkedList<>(),0);
        return res;
    }

    public void backtrack(int[] candidates, int target, Deque<Integer> list,int index){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i>index && candidates[i] == candidates[i-1]) continue;

            int candidate = candidates[i];
            list.addLast(candidate);
            backtrack(candidates,target-candidate,list,i+1);
            list.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] x = {10,1,2,7,6,1,5};
        int y = 8;
        x007_combinationSum2_40 x007_combinationSum2_40 = new x007_combinationSum2_40();
        x007_combinationSum2_40.combinationSum2(x,y);
    }
}
