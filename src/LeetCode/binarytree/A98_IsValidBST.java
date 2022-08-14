package LeetCode.binarytree;

import base.TreeNode;

public class A98_IsValidBST {
    public static void main(String[] args) {

    }

    // 验证二叉搜索树

    long pre = Long.MIN_VALUE;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;

    }

    public void helper(TreeNode root) {

        if (root == null || !isValid) return;

        helper(root.left);

        if (root.val <= pre) {
            isValid = false;

            return;
        }
        pre = root.val;

        helper(root.right);
    }
}

