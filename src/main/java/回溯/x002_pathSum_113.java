package 回溯;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class x002_pathSum_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(root,targetSum,list,result);
        return result;
    }

    public  void backtrack(TreeNode root, int targetSum, List<Integer> list,List<List<Integer>> result){
        list.add(root.val);
        if(root.left ==null && root.right == null && root.val == targetSum){
            result.add(new ArrayList<>(list));
        }
        if(root.left!=null)
            backtrack(root.left,targetSum-root.val,list,result);
        if(root.right!=null)
            backtrack(root.right,targetSum-root.val,list,result);
        list.remove(list.size()-1);
    }


}
