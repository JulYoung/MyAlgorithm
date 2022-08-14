package LeetCode;

import java.util.ArrayDeque;

// 直方图中最大的矩形
public class A84_LargestRectangleInHistogram {



    static class Solution{
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1){
                return heights[0];
            }

            int res = 0;
            // 利用单调栈找边界
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {

                while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                    int curHeight = heights[stack.pollLast()];

                    // 处理相同元素的情况
                    while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                        stack.pollLast();
                    }

                    // 求宽度
                    int curWidth;
                    if (stack.isEmpty()) {
                        curWidth = i;
                    } else {
                        curWidth = i - stack.peekLast() - 1;
                    }

                    res = Math.max(res, curHeight * curWidth);
                }
                stack.addLast(i);  // 添加索引
            }

            // 处理栈不空的情况
            while (!stack.isEmpty()) {
                int curHeight = heights[stack.pollLast()];
                // 处理相同元素的情况
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                // get width
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = len;
                } else {
                    curWidth = len - stack.peekLast() - 1;
                }

                res = Math.max(res, curHeight * curWidth);
            }
            return res;
        }
    }
}

