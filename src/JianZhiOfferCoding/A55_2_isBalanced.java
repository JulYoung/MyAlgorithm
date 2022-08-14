package JianZhiOfferCoding;

import base.TreeNode;

// 判断是否是平衡二叉树
public class A55_2_isBalanced {
    public static void main(String[] args) {

    }

    static class Solution {

        public boolean isBalanced(TreeNode root) {
            return helper(root) != -1;
        }

        public int helper(TreeNode root) {
            if (root == null) {
                return 0;  // 高度为0
            }
            int lh = helper(root.left);  // 左子树高度
            if (lh == -1) return -1; // 剪枝

            int rh = helper(root.left);  // 右子树高度
            if (rh == -1) return -1;

            // -1 代表不是平衡二叉树
            return Math.abs(lh - rh) < 2 ? Math.max(lh , rh) + 1 : -1;
        }
    }
}

