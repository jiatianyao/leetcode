package 树;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *  
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class d001_preorder_589 {
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if(root ==null) return list;
        list.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            preorder(child);
        }
        return list;
    }


}
