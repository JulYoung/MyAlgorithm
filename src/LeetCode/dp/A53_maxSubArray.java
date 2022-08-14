package LeetCode.dp;

public class A53_maxSubArray {

    // 最小自序和
    //    最值问题 + 子问题 = DP
    //
    public int maxSubArray(int[] nums) {

        // 定义DP[i]: 以 nums[i] 为结尾的「最大子数组和」为 dp[i]。
        int[] dp = new int[nums.length];

        // base case；
        dp[0] = nums[0];

        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            // nums[i]加入前面或自成一派
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
