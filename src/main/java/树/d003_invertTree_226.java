package 树;

import common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树
 *  示例：
 *  输入：
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *  输出：
 *       4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class d003_invertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
