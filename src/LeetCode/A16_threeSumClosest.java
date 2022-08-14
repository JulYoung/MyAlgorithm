package LeetCode;

import java.util.Arrays;

public class A16_threeSumClosest {
    public static void main(String[] args) {
        Solution solution = new Solution();


    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 排序
            Arrays.sort(nums);

            int res = Integer.MAX_VALUE;

            for (int k = 0; k < nums.length - 2; k++) {
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    if (sum > target) {
                        j--;
                    } else if (sum < target) {
                        i++;
                    } else
                        return res;
                }

            }
            return res;
        }
    }

}

