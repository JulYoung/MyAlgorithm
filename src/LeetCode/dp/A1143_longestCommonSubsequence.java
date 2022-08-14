package LeetCode.dp;

public class A1143_longestCommonSubsequence {

    // 最长公共子序列
    // 动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
        // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // base case: dp[0][..] = dp[..][0] = 0

        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
