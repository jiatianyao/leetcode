package 深搜广搜;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 示例 1:
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 * 示例 2:
 * 输入:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 */
public class l016_findBottomLeftValue_513 {
    //广度搜索
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode res = bfs(queue,root);
        return res.val;
    }

    private TreeNode bfs(Queue<TreeNode> queue,TreeNode res) {
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res = node;
            if(node.right !=null) {
                queue.offer(node.right);
            };
            if(node.left !=null) {
                queue.offer(node.left);
            }
        }
        return res;
    }
}
