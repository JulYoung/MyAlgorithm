package LeetCode.binarytree;


import base.TreeNode;

public class A105_BuildTreeByPre_Inorder {
    public static void main(String[] args) {

    }

    // 根据前序和中序构造二叉树
    int[] preorder;
    int[] inorder;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        idx = 0;

        return build(0, inorder.length - 1);
    }

    public TreeNode build(int left, int right) {
        // base
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx]);

        int mid = 0;
        for (int i = left; i <= right; i++) {
            if (preorder[idx] == inorder[i]) {
                mid = i;
                break;
            }
        }
        idx++;

        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);
        return root;
    }
}

