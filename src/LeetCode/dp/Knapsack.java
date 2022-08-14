package LeetCode.dp;

// 背包问题
public class Knapsack {
    public static void main(String[] args) {
        int w = 4;
        int n = 3;
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        System.out.println(knapsack(w, n, wt, val));
    }

    /**
     * 0-1背包问题
     *
     * @param w   背包可装载重量
     * @param n   有n个物品
     * @param wt  每个物品的重量
     * @param val 每个物品的价值
     * @return 返回背包所能装下的最大价值
     */
    static int knapsack(int w, int n, int[] wt, int[] val) {
        // dp[i][j]: 前i个物品装在承载重量为的j背包下时的最大价值
        int[][] dp = new int[n + 1][w + 1];

        // base case
        // 一行一列均为0

        // 状态转移
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                // 当前物品不能装入
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }
        return dp[n][w];
    }
}
