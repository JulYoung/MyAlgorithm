package LeetCode.dp;

//494. 目标和
public class A494_FindTargetSumWays {
    public static void main(String[] args) {
        A494_FindTargetSumWays so = new A494_FindTargetSumWays();
        System.out.println(so.findTargetSumWays(new int[]{100}, -200));

    }

    // 将nums分为两个集合A，B。A和B分别是加正号和负号的
    // 那么sum(A) - sum(B) = target
    // sum(A) = target + sum(B)
    // sum(A) + sum(A) = target + sum(A) + sum(B)
    // 2sum(A) = target + sum(nums)
    // 那么问题转化为求nums中有多少种装法能装满(target + sum(nums)) / 2 大的背包
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        // 这两种情况，不可能存在合法的子集划分
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        return subSets(nums, (sum + target) / 2);
    }

    int subSets(int[] nums, int sum) {
        // 定义DP
        int[][] dp = new int[nums.length + 1][sum + 1];

        // base case
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }

        // 转移
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
