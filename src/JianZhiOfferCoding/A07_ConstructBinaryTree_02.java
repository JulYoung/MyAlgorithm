package JianZhiOfferCoding;


// 重建二叉树
public class A07_ConstructBinaryTree_02 {

    public static void main(String[] args) {

        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        TreeNode rootNode = solution.buildTree(preorder, inorder);
        solution.print(rootNode);

    }


    // 二叉树结构
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        private int pre = 0;
        private int in = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 判断异常
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            return buildTree(preorder, inorder, Integer.MIN_VALUE); // 第三个参数是不存在于二叉树中的任意数均可
//            return helper(preorder, inorder, 0, 0, inorder.length - 1);
        }

        // 递归 分治法
        public TreeNode buildTree(int[] preorder, int[] inorder, int stop) {

            if (pre > preorder.length - 1) {
                return null;
            }
            if (inorder[in] == stop) {
                in++;
                return null;
            }

            TreeNode root = new TreeNode(preorder[pre++]);
            root.left = buildTree(preorder, inorder, root.val);
            root.right = buildTree(preorder, inorder, stop);
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
