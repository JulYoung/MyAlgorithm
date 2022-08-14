package LeetCode.dp;

public class A583_minDistance {
    public static void main(String[] args) {

    }


    // 两个字符串的删除操作, 求将两个字符串变为一样的最小删除步骤
    public int minDistance(String word1, String word2) {
        // 定义DP
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // base case
        // 第一列
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        // 第一行
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        // 转移
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


}

