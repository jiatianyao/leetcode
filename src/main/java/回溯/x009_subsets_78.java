package 回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class x009_subsets_78 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new LinkedList<>());
        res.add(new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int index, Deque<Integer> list){
        if(index == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            list.addLast(num);
            res.add(new ArrayList<>(list));
            backtrack(nums,i+1,list);
            list.removeLast();

        }

    }
}
