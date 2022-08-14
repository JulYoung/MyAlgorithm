package JianZhiOfferCoding;

import base.TreeNode;

// 树的镜像
public class A27_MirrorTree {
    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            reverse(root);
            return root;
        }
        public void reverse(TreeNode root) {
            if (root ==  null)
                return;
            reverse(root.left);
            reverse(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
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