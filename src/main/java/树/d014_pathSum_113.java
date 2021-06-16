package 树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有
 * 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 */
public class d014_pathSum_113 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        if(root ==null){
            return res;
        }
        dfs(new ArrayList<Integer>(),root,targetSum);
        return res;
    }

    public void dfs(ArrayList<Integer> curPath, TreeNode node, int targetSum ){
        curPath.add(node.val);//能进来肯定保证非空
        if(node.left==null&&node.right==null&& node.val == targetSum ){
            res.add(new ArrayList<>(curPath));
        }
        if(node.left!=null)
            dfs(curPath,node.left,targetSum-node.val);
        if(node.right!=null)
            dfs(curPath,node.right,targetSum-node.val);
        curPath.remove(curPath.size()-1);//回溯
    }
}



