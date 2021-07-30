package 树;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 958. 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 * 示例 1：
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 * 提示：
 * 树中将会有 1 到 100 个结点。
 */
public class l121_isCompleteTree_958_2 {
    public boolean isCompleteTree(TreeNode root) {
        if(root ==null) return true;
        int n = getCount(root);
        //cnt为当前层满节点数,m当前层节点数
        int m = 1,cnt = 1;
        while (cnt+2*m <= n){
            m *=2;
            cnt+=m;
        }
        return judge(root,n,m);
    }

    public int getCount(TreeNode root){
        if(root ==null) return 0;
        return getCount(root.left) + getCount(root.right) +1;
    }

    public boolean judge(TreeNode root,int n,int m){
        if(root == null) return n ==0;
        if(n == 0)  return false;
        if(n == 1) return root.left == null && root.right ==null;
        //根节点到M层共有多少数据
        int k = Math.max(2 * m -1,0);
        int l = Math.min(n-k ,m);
        int r = n-k-l;
        return judge(root.left,(k-1) /2 +l,m/2) &&
                judge(root.right,(k-1) /2 +r,m/2);
    }
}
