package LeetCode.dp;

public class A712_MinimumDeleteSum {
    public static void main(String[] args) {
        char ch = 'A' + 1;
        System.out.println(ch);

        A712_MinimumDeleteSum so = new A712_MinimumDeleteSum();
        int i = so.minimumDeleteSum("sea", "eat");
        System.out.println(i);
    }


    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // base case
        // 第一列
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        // 第一行
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }

        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j - 1), dp[i - 1][j] + s1.charAt(i - 1));
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

