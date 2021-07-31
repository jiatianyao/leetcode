package 树;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 *
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class l123_pathSum_437 {
    public int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        bfs(root,targetSum);
        return res;
    }

    private void bfs(TreeNode root, int targetSum) {
        if(root ==null ) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
            dfs(node,targetSum-node.val);
        }
    }

    private void dfs(TreeNode node, int targetSum) {
        if(targetSum ==0) res++;
        if(node ==null) return;
        if(node.left!=null){
            dfs(node.left,targetSum-node.left.val);
        }
        if(node.right!=null){
            dfs(node.right,targetSum-node.right.val);
        }
    }

    public static void main(String[] args) {
        l123_pathSum_437 demo = new l123_pathSum_437();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(-2);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(-1);
        root.left = root2;
        root2.left = root3;
        root2.right = root4;
        root3.left = root5;
        demo.pathSum(root,-1);
        System.out.println(demo.res);
    }
}
