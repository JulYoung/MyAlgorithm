package LeetCode.binarytree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class A95_GenerateTrees {
    public static void main(String[] args) {

    }

    // 构造不同的二叉树
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();

        // 构造闭区间[1, n] 组成BST
        return build(1, n);
    }

    // 构造闭区间 [lo, hi] 组成的 BST
    // 返回[lo, hi]能组成树的全部集合
    public List<TreeNode> build(int low, int high) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            // 递归构造出左右子树BST
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);

            // 给root节点穷举所有左右子树的组合
            for (TreeNode le : leftTree) {
                for (TreeNode ri : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    root.right = ri;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

