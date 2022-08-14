package LeetCode.binarytree;

import base.TreeNode;

public class A538_ConvertBST {
    public static void main(String[] args) {

    }

    // 把二叉搜索树转换为累加树

    public TreeNode convertBST(TreeNode root) {
        this.sum = 0;
        helper(root);
        return root;
    }

    int sum;

    public void helper(TreeNode root) {
        if (root == null) return;

        helper(root.right);

        sum += root.val;
        root.val = sum;

        helper(root.left);
    }
}

