package LeetCode.binarytree;

import base.TreeNode;

public class A654_ConstructMaxBinaryTree {
    public static void main(String[] args) {

    }

    // 根据数组，构造最大二叉树
    // 先序遍历框架
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        // base
        if (left > right) {
            return null;
        }

        // 找最大值
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        // 构造根节点
        TreeNode root = new TreeNode(max);

        // 前序遍历框架
        root.left = build(nums, left, idx - 1);
        root.right = build(nums, idx + 1, right);

        return root;
    }
}
