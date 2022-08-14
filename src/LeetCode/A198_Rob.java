package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 198 打家劫舍
// https://leetcode-cn.com/problems/house-robber/
public class A198_Rob {
    public static void main(String[] args) {
        A198_Rob so = new A198_Rob();
        System.out.println(so.rob(new int[]{2,7,9,3,1}));
        System.out.println(so.robEnhanced(new int[]{2,7,9,3,1}));

    }
    // 利用动态规划
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 定义dp
        int[] dp = new int[nums.length + 1];

        // base case
        dp[0] = 0;
        dp[1] = nums[0];

        // 状态转移
        for (int i = 2; i < dp.length; i++) {
            if (nums[i - 1] + dp[i - 2] > dp[i - 1]) {
                dp[i] = nums[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    // 打家劫舍进阶，输出偷窃哪几家
    public List<Integer> robEnhanced(int[] nums) {
        if (nums.length == 1)
            return new ArrayList<>(nums[0]);
        // 定义dp
        int len = nums.length + 1;
        int[] dp = new int[len];
        int[] record = new int[len];

        // base case
        dp[0] = 0;
        dp[1] = nums[0];
        record[0] = 0;
        record[1] = 1;

        // 状态转移
        for (int i = 2; i < dp.length; i++) {
            if (nums[i - 1] + dp[i - 2] > dp[i - 1]) {
                dp[i] = nums[i - 1] + dp[i - 2];
                record[i] = i - 2;
            } else {
                dp[i] = dp[i - 1];
                record[i] = i - 1;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        int i = len - 1;
        while (record[i] != i) {
            if (record[i] + 1 != i) {
                list.addFirst(i - 1);
            }
            i = record[i];
        }
        if (i != 0) {
            list.addFirst(i - 1);
        }

        return list;
    }
}

