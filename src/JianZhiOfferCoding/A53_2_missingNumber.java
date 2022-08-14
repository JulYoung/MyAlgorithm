package JianZhiOfferCoding;

//
public class A53_2_missingNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }

    // 二分查找
    static class Solution {
        public int missingNumber(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            int mid;
            while (l < r) {
                mid = (l + r) / 2;
                if (nums[mid] == mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}

