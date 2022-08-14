package LeetCode;

// 买卖股票的最佳时机,允许多次买卖
public class A122_BestTimeToBuyAndSellStock2 {


    static class Solution {
        // 贪心
        public int maxProfit(int[] prices) {

            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }

        // 动态规划
        public int maxProfit2(int[] prices) {

            // 行表示某一天，列表示两种状态，0表示先进，1表示股票
            int[][] dp = new int[prices.length][2];

            // 初始化
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                // 状态转移
                //
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
}

