package 回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class x006_combinationSum_39 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            int candidate = candidates[i];
            list.addLast(candidate);
            backtrack(candidates,target-candidate,list,i);
            list.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] x = {2,3,6,7};
        int y = 7;
        x006_combinationSum_39 x006_combinationSum_39 = new x006_combinationSum_39();
        x006_combinationSum_39.combinationSum(x,y);
    }
}
