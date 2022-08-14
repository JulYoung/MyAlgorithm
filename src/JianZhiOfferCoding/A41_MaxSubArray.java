package JianZhiOfferCoding;

// 连续子数组的最大和
public class A41_MaxSubArray {
    public static void main(String[] args) {
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}


