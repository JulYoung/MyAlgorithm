package JianZhiOfferCoding;

import base.TreeNode;

// 二叉树的深度
public class A55_1_MaxDepth {
    public static void main(String[] args) {

    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            return dfs(root);
        }
        public int dfs(TreeNode root) {

            if (root == null)
                return 0;
            int lh = dfs(root.left);
            int rh = dfs(root.right);
            return Math.max(lh, rh) + 1;
        }
    }
}

