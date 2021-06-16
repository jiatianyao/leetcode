package 回溯;

import java.util.*;

public class x010_subsetsWithDup_90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new LinkedList<>(),new boolean[nums.length]);

        res.add(new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int index, Deque<Integer> list,boolean[] visit){
        if(index == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            /**
             * 集合[1,2,2]
             * 选择
             * {1}√                     {2}  {2}× 不能选 nums[i] == nums[i-1] 并且 前一个没有被访问
             * {1,2}√ {1,2}×            {2,2}√ 可以选择：nums[i] == nums[i-1] 并且前一个被访问了
             * 不能选 nums[i] == nums[i-1] 并且 前一个没有被访问
             *
             * 故判断条件为前一个是否被访问，并且当前值和前一个相等
             */
            if(i> 0 && visit[i-1] == false  && nums[i] == nums[i-1]) continue;
            visit[i] = true;
            list.addLast(num);
            res.add(new ArrayList<>(list));
            backtrack(nums,i+1,list,visit);
            visit[i] = false;
            list.removeLast();

        }

    }
}
