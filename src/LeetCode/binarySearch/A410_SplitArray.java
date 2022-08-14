package LeetCode.binarySearch;

public class A410_SplitArray {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int split = split(nums, mid);
            if (split < m) {
                right = mid - 1;
            } else if (split > m) {
                // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * @param nums           原始数组
     * @param maxIntervalSum 子数组各自的和的最大值
     * @return 满足不超过「子数组各自的和的最大值」的分割数
     */
    int split(int[] nums, int maxIntervalSum) {
        // 至少是一个分割
        int splits = 1;
        // 当前区间的和
        int curIntervalSum = 0;
        for (int num : nums) {
            // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }
}
