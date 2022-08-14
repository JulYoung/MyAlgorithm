package LeetCode.dp;

public class A931_minFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {  // 1 行
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix[0].length; i++) {
                min = Math.min(min, matrix[0][i]);
            }
            return min;
        }
        if (matrix[0].length == 1) {
            int res = 0;
            for (int i = 0; i < matrix.length; i++) {
                res += matrix[i][0];
            }
            return res;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        // base case
//            for (int i = 1; i < matrix[0].length; i++) {
//                dp[1][i] = matrix[1][i];
//            }

        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j == 1) {
                    int temp = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    dp[i][j] = temp + matrix[i - 1][j - 1];
                } else if (j == dp.length - 1) {
                    int temp = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = temp + matrix[i - 1][j - 1];
                } else {
                    int temp = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]);
                    dp[i][j] = temp + matrix[i - 1][j - 1];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < dp[0].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }
}
