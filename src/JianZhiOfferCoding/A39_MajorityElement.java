package JianZhiOfferCoding;

// 数组中出现次数超过一半的数字
public class A39_MajorityElement {
    public static void main(String[] args) {

    }
    // 常见三种解法:
    // 1. 哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，即可找出 众数 。此方法时间和空间复杂度均为 O(N)O(N) 。
    // 2. 数组排序法： 将数组 nums 排序，数组中点的元素 一定为众数。
    // 3. 摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ，为本题的最佳解法。
    static class Solution {
        public int majorityElement(int[] nums) {
            int votes = 0, majority = 0;
            for (int num : nums) {
                if (votes == 0) {
                    majority = num;  // 票数为0时，假设当前数为众数
                }
                if (majority == num)  // 为众数，加一
                    votes++;
                else
                    votes--;  // 不为众数，减一
            }
            return majority;
        }
    }

}


