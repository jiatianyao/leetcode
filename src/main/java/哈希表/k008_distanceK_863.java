package 哈希表;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 */
public class k008_distanceK_863 {
    Map<TreeNode,TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root,null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(target);

        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        set.add(null);
        int dist = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
               if(dist == k){
                   ArrayList<Integer> ans = new ArrayList<>();
                   for (TreeNode treeNode : queue) {
                       ans.add(treeNode.val);
                   }
                   return ans;
               }
               queue.offer(null);
               dist++;
            }else{
                if(!set.contains(node.left)){
                    set.add(node.left);
                    queue.offer(node.left);
                }
                if(!set.contains(node.right)){
                    set.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if(!set.contains(par)){
                    set.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<>();
    }

    public void dfs(TreeNode node, TreeNode par){
        if(node != null){
            parent.put(node, par);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
