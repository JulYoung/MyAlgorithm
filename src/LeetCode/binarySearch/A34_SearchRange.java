package LeetCode.binarySearch;

import java.util.Arrays;

public class A34_SearchRange {
    public static void main(String[] args) {
        A34_SearchRange so = new A34_SearchRange();
        System.out.println(Arrays.toString(so.searchRange(new int[]{1}, 1)));

    }
    public int[] searchRange(int[] nums, int target) {
        // 寻找target的左边界
        // 寻找target + 1 的左边界
        int left = binarySearch(nums, target);
        if (left >= nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }
        int right = binarySearch(nums, target + 1);

        return new int[]{left, right - 1};
    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
