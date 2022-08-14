package LeetCode;

// 除自身以外数组的乘积
public class A238_ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // 从前往后
        res[0] = 1;  // res[i]表示[0...i-1]乘积。
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // 从后往前
        int temp = nums[nums.length - 1];
        for (int i = res.length - 2; i >=0 ; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }

}

