package 回溯;

import java.util.*;

public class x010_subsetsWithDup_90_2 {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new LinkedList<>());
        ans.add(new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void backtrack(int[] nums, int index, Deque<Integer> list){
        if(index == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            list.addLast(num);
            ans.add(new ArrayList<>(list));
            backtrack(nums,i+1,list);

            list.removeLast();

        }

    }
}
