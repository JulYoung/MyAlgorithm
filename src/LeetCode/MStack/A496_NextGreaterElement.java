package LeetCode.MStack;

import java.util.HashMap;
import java.util.Stack;

public class A496_NextGreaterElement {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[len2];
        int[] res = new int[len1];

        HashMap<Integer, Integer> map = new HashMap<>();

        // 求出nums2的下一个较大元素
        //    利用单调栈框架
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 维持单调栈特性
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }

            temp[i] = stack.isEmpty() ? -1 : stack.peek();

            map.put(nums2[i], i);  // 利用hashmap

            stack.push(nums2[i]);
        }

        // 求出子集nums1的下一个较大元素
        for (int i = 0; i < len1; i++) {
            res[i] = temp[map.get(nums1[i])];
        }

        return res;
    }
}

