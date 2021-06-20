package 深搜广搜;

import common.TreeNode;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class l005_isCousins_993 {
    // 解法1:深搜
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xints = dfs(root,null,0,x);
        int[] yints = dfs(root,null,0,y);
        return xints[0] != yints[0] && xints[1] == yints[1];
    }

    /**
     *
     * @param node 需要遍历节点
     * @param father 当前节点的父节点
     * @param depth 当前深度
     * @param x 需要查找的节点
     * @return 父节点/层数
     */
    private int[] dfs(TreeNode node, TreeNode father, int depth, int x) {
        if(node == null) return new int[]{-1,-1};
        if(node.val == x){
            return new int[]{father !=null ? father.val : 1,depth};
        }
        int[] l = dfs(node.left,node,depth+1,x);
        if(l[0] != -1)return l;
        return  dfs(node.right,node,depth+1,x);
    }
}
