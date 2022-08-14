package LeetCode;

import java.util.HashMap;

public class A1_twoSum {
    public static void main(String[] args) {

    }

    // 数组未排序。两数之和
    public int[] twoSum(int[] nums, int target) {
        // <值, 索引>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }
        return new int[]{-1, -1};
    }

}


