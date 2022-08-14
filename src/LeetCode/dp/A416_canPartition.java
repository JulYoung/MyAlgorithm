package LeetCode.dp;

public class A416_canPartition {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 5,11, 5};
        boolean f = solution.canPartition(ints);
        System.out.println(f);

    }


    static class Solution {
        // 分割等和子集：nums数组是否可以分割成两个子集，并且和相等
        // 转化为0-1背包问题：一个子集就相当于一个背包，子集的容量为sum / 2。
        // 看nums中的元素是否能刚好填满子集
        public boolean canPartition(int[] nums) {
            // 求和
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            sum /= 2; // 背包大小
            // 定义dp[i][j], nums[0...i]是否能填满容量为j的背包
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];

            // base case
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = true;
            }

            // 转移
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    // 当前重量大于背包容量，能否填满取决于[0...i-1]能否填满
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 能否填满，取决于加入或不加入子集时能否填满
                        // dp[i - 1][j]: 不加入
                        // dp[i - 1][j - nums[i - 1]]: 加入
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                    System.out.print(dp[i][j] + "  ");
                }
                System.out.println("");
            }
            return dp[nums.length][sum];
        }
    }
}
