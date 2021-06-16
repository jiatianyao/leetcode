package 树;

import common.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在
 * 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class d009_hasPathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root ==null) return false;
        if(root.left ==null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left,targetSum - root.val) ||
                hasPathSum(root.right,targetSum - root.val);

    }
}


