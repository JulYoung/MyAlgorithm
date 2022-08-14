package JianZhiOfferCoding;

// 顺时针打印矩阵
public class A29_SpiralOrder {
    public static void main(String[] args) {
    }

    static class Solution {
        public int[] spiralOrder(int[][] matrix) {
            // 特殊处理
            if (matrix == null)
                return null;
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;

            int[] res = new int[(r + 1) * (b + 1)];
            int x = 0;

            while (true) {
                // 左到右
                for (int i = l; i <= r; i++) {
                    res[x++] = matrix[t][i];
                }
                if (++t > b) break;;
                // 上到下
                for (int i = t; i <= b; i++) {
                    res[x++] = matrix[i][r];
                }
                if (--r < l) break;
                // 右到左
                for (int i = r; i >= l ; i--) {
                    res[x++] = matrix[b][i];
                }
                if (--b < t) break;
                // 下到上
                for (int i = b; i >= t; i--) {
                    res[x++] = matrix[i][l];
                }
                if (++l > r) break;
            }
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