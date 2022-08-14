package JianZhiOfferCoding;

import java.util.Arrays;

// 快速幂运算
public class A21_ReorderArray {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,6,8};
        Solution solution = new Solution();
        int[] exchange = solution.exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }

    static class Solution {
        public int[] exchange(int[] nums) {
            int i = 0, j = nums.length - 1;
            int temp;
            while ( i < j) {
                while (i < j && nums[i] % 2 != 0) {
                    i++;
                }
                while (i < j && nums[j] % 2 != 1) {
                    j--;
                }
                if (i < j) {
//                    System.out.println(nums[i] + " " + nums[j]);
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

            return nums;
        }
    }

}
