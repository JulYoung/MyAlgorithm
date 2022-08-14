package JianZhiOfferCoding;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 剑指 Offer 59 - I. 滑动窗口中的最大值
public class A59_1_MaxSlidingWindow {
    public static void main(String[] args) {
        A59_1_MaxSlidingWindow so = new A59_1_MaxSlidingWindow();
        int[] res = so.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }

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

    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];

        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除deque中对应的num[i - 1]
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }

            // 保持队列单调性
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }

            deque.addLast(nums[j]);

            if (i >= 0) {
                res[i] = deque.peekFirst();
            }

        }
        return res;
    }
}

