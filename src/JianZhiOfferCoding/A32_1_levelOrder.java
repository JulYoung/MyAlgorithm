package JianZhiOfferCoding;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

// 从上到下打印二叉树
public class A32_1_levelOrder {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] levelOrder(TreeNode root) {
            // 特殊化处理
            if (root == null)
                return new int[0];
            // 借助队列
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            ArrayList<Integer> ans = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                ans.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right!= null) queue.add(node.right);
            }
            int[] res = new int[ans.size()];
            for(int i = 0; i < ans.size(); i++)
                res[i] = ans.get(i);
            return res;

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