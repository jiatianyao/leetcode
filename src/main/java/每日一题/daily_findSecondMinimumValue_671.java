package 每日一题;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 *
 *
 *
 */
public class daily_findSecondMinimumValue_671 {

    public static int findSecondMinimumValue(TreeNode root) {
        return bfs(root);
    }

    private static int bfs(TreeNode root) {
        if(root ==null) return -1;
        int minVal = root.val;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        //坑,不能用int类型,有个用例是比int最大还大1
        long secondVal = Long.MAX_VALUE;
        while(!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null && left.val != minVal) {
                    secondVal = Math.min(left.val, secondVal);
                }
                if (right != null && right.val != minVal) {
                    secondVal = Math.min(right.val, secondVal);
                }
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        return secondVal==Long.MAX_VALUE ? -1 : (int)secondVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2147483647);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;

        findSecondMinimumValue(root);
    }
}
