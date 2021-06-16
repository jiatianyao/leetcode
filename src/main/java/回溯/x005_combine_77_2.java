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
public class x005_combine_77_2 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1,new LinkedList<>());
        return res;
    }

    public void backtrack(int n ,int k,int index, Deque<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.addLast(i);
            backtrack(n,k,i+1,list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        x005_combine_77_2 x005_combine_77_2 = new x005_combine_77_2();
        x005_combine_77_2.combine(4,2);
    }
}
