package LeetCode.binarytree;

import base.TreeNode;

public class A450_DeleteNode {
    public static void main(String[] args) {

    }
    // 删除二叉搜索树中的节点
    // 三种情况：
    //   1. 该节点没有子节点，直接删除
    //   2. 该节点只有一个子节点，用子节点代替该节点
    //   3. 被删除节点有两个子节点。为了不破坏二叉搜索树的性质，被删除节点必须找到左子树中最大的那个节点，
    //   或右子树中最小的节点来接替自己（后面的代码示例选择第二种方式）。
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = findMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}

