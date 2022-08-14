package LeetCode.binarytree;


public class A106_BuildTreeByIn_Postorder {
    public static void main(String[] args) {

    }

    // 根据后序和中序构造二叉树
    int[] inorder;
    int[] postorder;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        idx = postorder.length - 1;

        return build(0, inorder.length - 1);
    }

    public TreeNode build(int left, int right) {
        // base
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[idx]);

        int mid = 0;
        for (int i = left; i <= right; i++) {
            if (postorder[idx] == inorder[i]) {
                mid = i;
                break;
            }
        }
        idx--;

        // 后序，需要先更新右子树
        root.right = build(mid + 1, right);
        root.left = build(left, mid - 1);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }
}

