package LeetCode.binarytree;

import base.TreeNode;

public class A114_Flatten {
    public static void main(String[] args) {

    }

    // 将二叉树展开为链表

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;
        // 找到最后一个节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


}

