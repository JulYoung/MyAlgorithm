package LeetCode.binarytree;


import base.TreeNode;

public class A226_InvertTree {
    public static void main(String[] args) {

    }
    // 翻转二叉树，后序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }


}

