package LeetCode.dp;

public class A518_coinChange_2 {
    public static void main(String[] args) {
        A518_coinChange_2 so = new A518_coinChange_2();
        System.out.println(so.change(5, new int[]{1, 2, 5}));
    }

    // 零钱兑换2 -- 完全背包问题
    // 求面值为coins的硬币能凑出amount金额的凑法数
    public int change(int amount, int[] coins) {
        // dp[i][j] 前i种硬币凑出总金额j的硬币组合数
        int[][] dp = new int[coins.length + 1][amount + 1];

        // base case : 第一列为1
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;  // 无为而治，凑出0的总金额为1.
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // dp[i - 1][j] 不放当前
                    // dp[i][j - coins[i-1]] 放当前
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
