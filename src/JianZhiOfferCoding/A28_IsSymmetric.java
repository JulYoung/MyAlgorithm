package JianZhiOfferCoding;

import base.TreeNode;

// 对称二叉树
public class A28_IsSymmetric {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            // 后序
            if (root == null)
                return true;
            return helper(root.left, root.right);


        }

        public boolean helper(TreeNode LNode, TreeNode RNode) {
            if (LNode == null && RNode == null)
                return true;


            if (LNode == null || RNode == null || LNode.val != RNode.val) {
                return false;
            }

            return helper(LNode.left, RNode.right) && helper(LNode.right, RNode.left);

        }
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */