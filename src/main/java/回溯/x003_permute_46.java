package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class x003_permute_46 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new boolean[nums.length],new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums,boolean[] visit,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]) continue;
            int num = nums[i];
            list.add(num);
            visit[i]  = true;
            backtrack(nums,visit,list);
            list.remove(list.size()-1);
            visit[i]  = false;
        }
    }
}
