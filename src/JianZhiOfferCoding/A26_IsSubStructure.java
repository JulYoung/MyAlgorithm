package JianZhiOfferCoding;

import base.TreeNode;

// 树的子结构
public class A26_IsSubStructure {
    public static void main(String[] args) {

    }

    static class Solution {
        // 递归 + 先序
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // 先序
            if (A == null || B == null) {
                return false;
            }
            if (A.val == B.val) {
                // 判断后续 B 是否是 A 的子树
                if (helper(A.left, B.left) && helper(A.right, B.right))
                    return true;
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean helper(TreeNode r1, TreeNode r2) {
            if (r2 == null) {
                return true;
            }
            if (r1 == null) {
                return false;
            }
            if (r1.val == r2.val) {
                return helper(r1.left, r2.left) && helper(r1.right, r2.right);
            } else
                return false;
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