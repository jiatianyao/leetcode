package 回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class x005_combine_77 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        backtrack(nums,0,new LinkedList<>(),k,new boolean[n]);
        return res;
    }

    public void backtrack(int[] nums, int index, Deque<Integer> list,int k,boolean[] visit){
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if(list.size() ==k) {
                res.add(new ArrayList<>(list));
                break;
            }
            if(visit[i]) continue;
            visit[i] = true;
            list.addLast(num);
            backtrack(nums,i,list,k,visit);
            list.removeLast();
            visit[i] = false;
        }
    }
}
