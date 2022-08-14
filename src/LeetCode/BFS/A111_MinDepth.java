package LeetCode.BFS;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class A111_MinDepth {
    public static void main(String[] args) {


    }
    // bfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int depth = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
            depth++;
        }
        return depth;
    }

}

