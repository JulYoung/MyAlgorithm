package LeetCode;

import java.util.Arrays;
import java.util.Stack;

// 最长无序连续子数组：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
public class A581_FindUnsortedSubarray {
    public static void main(String[] args) {
        A581_FindUnsortedSubarray so = new A581_FindUnsortedSubarray();
        System.out.println(so.findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
    // 解法3：双指针 + 线性扫描 (优解，O(n))
    // https://www.cnblogs.com/kexinxin/p/10381393.html
    public int findUnsortedSubarray3(int[] nums) {
        int len = nums.length;
        int max = nums[0], end = -1;
        int min = nums[len - 1], start = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (nums[i] < max)
                end = i;
            if (nums[len - 1 - i] > min)
                start = len - 1 - i;
        }
        return end > start ? end - start + 1 : 0;
    }

    // 解法2：栈
    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(stack.pop(), left);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(stack.pop(), right);
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }

    //  解法1：排序，找前后不同，时间复杂度o(nlogn)
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int i = 0;
        while (i < nums.length && nums[i] == temp[i]) {
            i++;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[j] == temp[j]) {
            j--;
        }
        return j - i + 1;
    }

}

