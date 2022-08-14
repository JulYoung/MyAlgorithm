package JianZhiOfferCoding;

import java.util.Arrays;

public class A60_DicesProbability {
    public static void main(String[] args) {

    }

    // 动态规划
    public double[] dicesProbability(int n) {
        // 定义dp: dp[i][j] 代表前 i 个骰子的点数和 j 的概率
        double[] dp = new double[6];
        // 一个骰子时，各个点数的概率
        Arrays.fill(dp, 1 / 6.0); // fill() 函数

        // 动态规划
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}

