package LeetCode;


import java.util.HashMap;

public class A560_SubarraySum {
    public static void main(String[] args) {

    }
    // 利用前缀和
    public int subarraySum(int[] nums, int k) {

        // <前缀和, 该前缀和出现的频率>
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // nums[0]的前缀和必为0
        preSum.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // 如果当前和减去k等于一个值，这个值存在map中，则代表存在和为k的子数组。
            int temp = sum - k;
            if (preSum.containsKey(temp)) {
                res += preSum.get(temp);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }


    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}

