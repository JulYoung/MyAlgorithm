package JianZhiOfferCoding;

import base.TreeNode;

public class A68_2_LowestCommonAncestor {
    public static void main(String[] args) {

    }

    // 二叉树中的最近公共祖先

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // 先序遍历框架
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;  // 左右子树不为空，表示pq分别在root两侧，root为公共祖先

    }
}

