package LeetCode.MStack;

import java.util.Stack;

public class A739_DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 单调栈框架
            // 1. 保持特性
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // 2. 处理
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // 3. 采用索引入栈
            stack.push(i);
        }
        return res;
    }
}