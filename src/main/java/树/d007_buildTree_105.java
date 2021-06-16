package 树;

import common.TreeNode;

import java.util.TreeMap;

public class d007_buildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0) return null;
        if(preorder.length ==1) return new TreeNode(preorder[0]);
        int rootIndex = 0;
        while(preorder[0] != inorder[rootIndex]) ++rootIndex;
        int[] leftPre = new int[rootIndex],
                leftIn = new int[rootIndex],
                rightPre =  new int[inorder.length-1-rootIndex],
                rightIn =  new int[inorder.length-1-rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            leftIn[i] = inorder[i];
            leftPre[i] = preorder[i+1];
        }
        for (int i = rootIndex+1,j=0; i < inorder.length ; i++,j++) {
            rightIn[j] = inorder[i];
            rightPre[j] = preorder[i];
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(leftPre,leftIn);
        root.right = buildTree(rightPre,rightIn);
        return root;
    }

    public static void main(String[] args) {
        d007_buildTree_105 d007_buildTree_105 = new d007_buildTree_105();
        int[]  preorder = new int []{1,2,3};
        int[]  inorder = new int []{3,2,1};
        TreeNode treeNode = d007_buildTree_105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
