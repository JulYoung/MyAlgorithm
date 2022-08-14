package LeetCode.binarytree;

import base.TreeNode;

public class A701_InsertIntoBST {
    public static void main(String[] args) {

    }

    // 二叉搜索树中的插入操作

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
}

