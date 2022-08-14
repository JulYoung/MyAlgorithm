package LeetCode.dp;

import java.util.Arrays;

public class A322_coinChange {


    // 零钱兑换问题
    // 求amount的最小硬币个数，可以分成最小子问题
    // f(n) = min(f(n - coins[0]), ..., f(n-coins[len - 1]))
    public int coinChange(int[] coins, int amount) {
        // dp[i], 金额为i时的最小硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
