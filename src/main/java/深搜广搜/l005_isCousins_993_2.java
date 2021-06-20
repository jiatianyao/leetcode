package 深搜广搜;

import common.TreeNode;

import java.util.*;

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

/**
 *  广搜框架
 *  class Node{
 *      int val;
 *      List<Node> ADJ;
 *  }
 *  int BFS(Node start,Node target){
 *
 *  }
 */
public class l005_isCousins_993_2 {

    //解法2 广搜
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xints = bfs(root,x);
        int[] yints = bfs(root,y);
        return xints[0] != yints[0] && xints[1] == yints[1];
    }

    private int[] bfs(TreeNode root, int x) {
        //当前节点,父节点,当前层数
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root,null,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                Object[] poll = queue.poll();
                TreeNode cur = (TreeNode)poll[0];
                TreeNode father = (TreeNode)poll[1];
                int depth = (Integer) poll[2];
                if(cur.val == x) return new int[]{father !=null ? father.val : 0 ,depth};
                if(cur.left !=null) queue.offer(new Object[]{cur.left,cur,depth+1});
                if(cur.right !=null) queue.offer(new Object[]{cur.right,cur,depth+1});
            }
        }
        return new int[]{-1,-1};
    }
}
