package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class d004_offer_32 {
    int len = 0;

    public int[] levelOrder(TreeNode root) {
        if(root ==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        getLen(root);
        int[] arr = new int[len];

        queue.add(root);
        int xlen = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll == null) continue;
            arr[xlen++] = poll.val;
            queue.add(poll.left);
            queue.add(poll.right);
        }
        return arr;
    }

    public void getLen(TreeNode root){
        if(root ==null) return;
        len = len +1;
        getLen(root.left);
        getLen(root.right);
    }



}
