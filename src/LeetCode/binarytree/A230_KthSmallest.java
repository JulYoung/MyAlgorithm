package LeetCode.binarytree;

import base.TreeNode;

public class A230_KthSmallest {
    public static void main(String[] args) {

    }

    // 二叉搜索树中第K小
    public int kthSmallest(TreeNode root, int k) {
        this.cnt = 0;
        this.res = 0;
        helper(root, k);
        return res;
    }
    int cnt;
    int res;

    public void helper(TreeNode root, int k) {
        if (root == null) return;

        // 中序
        helper(root.left, k);

        cnt++;
        if (cnt == k) {
            res = root.val;
            return;
        }

        helper(root.right, k);
    }
}

