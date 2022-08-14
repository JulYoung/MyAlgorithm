package LeetCode.MStack;

import java.util.Stack;

public class A503_NextGreaterElements2 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();


        // 利用循环的特性
        for (int i = 2 * len - 1; i >= 0; i--) {
            // 单调栈框架
            // 1. 保持单调栈特性
            while (!stack.isEmpty() && nums[i % len] >= stack.peek()) {
                stack.pop();
            }
            // 2. 根据题目的一些处理
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            // 3. 将当前元素入栈
            stack.push(nums[i % len]);
        }
        return res;
    }
}
