package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 */
public class d013_widthOfBinaryTree_62 {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> quere = new LinkedList<Pair>();
        quere.offer(new Pair(root,0));
        int result=0;
        while(!quere.isEmpty()){
            int count = quere.size();
            int left = quere.peek().num;
            int right = 0;
            for (int i = 0; i < count; i++) {
                Pair poll = quere.poll();
                right = poll.num-left;
                if(poll.treeNode.left!=null){
                    quere.offer(new Pair(poll.treeNode.left,right*2));
                }
                if(poll.treeNode.right!=null){
                    quere.offer(new Pair(poll.treeNode.right,right*2+1));
                }
            }
            result = Math.max(result,right+1);
        }
        return result;
    }

     class Pair{
        TreeNode treeNode;
        int num;

        public Pair(TreeNode treeNode,int num){
            this.treeNode = treeNode;
            this.num = num;
        }
    }
}
