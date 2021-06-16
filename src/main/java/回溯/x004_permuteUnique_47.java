package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class x004_permuteUnique_47 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//在46基础上增加
        backtrack(nums,new boolean[nums.length],new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums,boolean[] visit,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]) continue;
            if(i>0 && nums[i] == nums[i-1]  && visit[i-1]) continue;//在46基础上增加
            int num = nums[i];
            list.add(num);
            visit[i]  = true;
            backtrack(nums,visit,list);
            list.remove(list.size()-1);
            visit[i]  = false;
        }
    }
}
