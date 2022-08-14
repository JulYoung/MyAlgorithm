package JianZhiOfferCoding;

import base.TreeNode;

// 二叉搜索树的第K大节点
public class A54_KthLargest {
    public static void main(String[] args) {

    }

    static class Solution {
        int k;
        int res;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.right);
            k--;
            if (k == 0) {
                res = root.val;
                return;
            }
            dfs(root.left);
        }
    }
}

