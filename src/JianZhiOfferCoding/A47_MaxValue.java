package JianZhiOfferCoding;

// 礼物的最大值
public class A47_MaxValue {
    public static void main(String[] args) {

    }

    // 动态规划
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}


