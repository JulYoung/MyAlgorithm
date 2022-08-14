package LeetCode.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;


public class A239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0, j = 0;
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        // 保持队列单调递减
        while (j < k && j < nums.length) {
            int cur = nums[j];
            j++;
            // 保持队列单调递减
            while (!deque.isEmpty() && deque.peekLast() < cur) {
                deque.pollLast();
            }
            deque.addLast(cur);
        }
        res[idx++] = deque.peekFirst();
        while (j < nums.length) {
            int cur = nums[j];
            j++;
            // 保持队列单调递减
            while (!deque.isEmpty() && deque.peekLast() < cur) {
                deque.pollLast();
            }
            deque.addLast(cur);
            if (nums[i] == deque.peekFirst())
                deque.removeFirst();
            i++;
            // 记录最大值
            res[idx++] = deque.peekFirst();
        }
        return res;
    }
}
