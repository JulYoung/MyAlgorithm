package LeetCode.binarySearch;

public class A1011_ShipWithinDays {
    public static void main(String[] args) {
    }

    // 在D天内送达包裹的能力
    public int shipWithinDays(int[] weights, int days) {
        int left;   // 可能的最小运载能力, 应为包裹重量的最大值。
        int right = 0;  // 可能的最大运载能力，应为所有包裹重量的和。
        int maxWeight = Integer.MIN_VALUE;
        for (int weight : weights) {
            right += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        left = maxWeight;

        // 二分查找 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int demand = calculateDemand(weights, mid);
            if (demand > days) {
                left = mid + 1;
            } else if (demand < days) {
                right = mid - 1;
            } else if (demand == days) {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * 一天的运载能力为num时，需要的天数
     */
    public int calculateDemand(int[] weights, int num) {
        int sum = 0;
        int day = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum == num) {
                day++;
                sum = 0;
            } else if (sum > num) {
                day++;
                sum = weights[i];
            }
        }
        if (sum != 0) {
            day++;
        }
        return day;
    }
}

