package LeetCode.DoublePointer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A870_AdvantageCount {
    public static void main(String[] args) {

    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);  // 升序
        int[] res = new int[nums1.length];
        // 大顶堆
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < nums2.length; i++) {
            maxpq.add(new int[]{i, nums2[i]});
        }
        int left = 0, right = nums1.length - 1;
        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            if (nums1[right] > pair[1]) {
                res[pair[0]] = nums1[right];
                right--;
            } else {
                res[pair[0]] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
