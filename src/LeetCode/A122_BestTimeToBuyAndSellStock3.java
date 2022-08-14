package LeetCode;

// 买卖股票的最佳时机,,最多完成两笔交易
public class A122_BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }


    static class Solution {
        // 动态规划
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int buy1 = -prices[0], sell1 = 0;
            int buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i < n; ++i) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }
}

