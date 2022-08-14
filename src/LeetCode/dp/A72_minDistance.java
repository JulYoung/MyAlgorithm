package LeetCode.dp;

public class A72_minDistance {

    /**
     * 求word1到word2的最小编辑距离
     * 最值问题 + 子问题 = DP
     * (1) dp[i-1][j-1]，即先将word1的前4个字符hors转换为word2的前2个字符ro，
     * 然后将第五个字符word1[4]（因为下标基数以0开始）由e替换为s（即替换为word2的第三个字符，word2[2]）
     * (2) dp[i][j-1]，即先将word1的前5个字符horse转换为word2的前2个字符ro，然后在末尾补充一个s，即插入操作
     * (3) dp[i-1][j]，即先将word1的前4个字符hors转换为word2的前3个字符ros，然后删除word1的第5个字符
     */

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        // 定义DP数组。dp[i][j]表示word1的前i个字符到word2的前j个字符的编辑距离
        int[][] dp = new int[n1 + 1][n2 + 1];

        // base case
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 当前字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }

}
