package LeetCode;

import java.util.Random;

// 215 数组中第k个最大元素
public class A215_FindKthLargest {
    public static void main(String[] args) {
        A215_FindKthLargest so = new A215_FindKthLargest();
        int kthLargest = so.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);


    }


    // Top K问题
    // 方法1：快排思想 + 随机轴选取
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    int quickSort(int[] nums, int left, int right, int k) {
        int i = left, j = right;
        if (left < right) {
            // 选取随机轴
            int rand = new Random().nextInt(right - left + 1) + left;
            swap(nums, left, rand);

            int temp = nums[left];
            while (i < j) {
                while (i < j && nums[j] <= temp) j--;
                while (i < j && nums[i] >= temp) i++;
                if (i < j) {
                    swap(nums, i, j);
                }
            }
            swap(nums, i, left);
        }
        if (i > k - 1) return quickSort(nums, left, i - 1, k);
        if (i < k - 1) return quickSort(nums, i + 1, right, k);
        return nums[i];
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

