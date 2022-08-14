package JianZhiOfferCoding;


// 重建二叉树
public class A07_ConstructBinaryTree {

    public static void main(String[] args) {

        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        TreeNode rootNode = solution.buildTree(preorder, inorder);
        solution.print(rootNode);

    }


    // 二叉树结构
    static class TreeNode {
        int val; // 数据域
        TreeNode left;  // 左子节点
        TreeNode right;  // 右子节点

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {  // 前序，中序
            // 判断异常
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
//            return helper(preorder, inorder, 0, 0, inorder.length - 1);
        }

        // 递归 分治法
        public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }

            // 创建当前根节点
            TreeNode root = new TreeNode(preorder[preStart]);
            int index = 0;  // 中序遍历中与当前根节点值相等的索引。可以利用hashmap
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    index = i;
                    break;
                }
            }
            root.left = buildTree(preorder, inorder, preStart + 1, inStart, index - 1);
            root.right = buildTree(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);

            return root;
        }

        // 遍历 打印
        public void print(TreeNode root) {
            if (root != null) {
                print(root.left);
                System.out.println(root.val);
                print(root.right);
            }
        }
    }
}
