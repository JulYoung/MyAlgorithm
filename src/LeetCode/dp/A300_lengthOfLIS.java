package LeetCode.dp;

import java.util.Arrays;

public class A300_lengthOfLIS {

    // 最长递增子序列
    public int lengthOfLIS(int[] nums) {

        // 定义dp：dp[i]表示以nums[i]结尾的子串的最长递增子序列
        int[] dp = new int[nums.length];

        // base case
        Arrays.fill(dp, 1);

        int max = dp[0];
        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            // 跟前面每一个元素进行比较
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
