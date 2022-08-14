package JianZhiOfferCoding;

import java.util.Arrays;

public class A56_2_SingleNumber {
    public static void main(String[] args) {

    }


    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        //只有三种情况
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 2] != nums[n - 1]) return nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                return nums[i];
        }
        return 0;
    }

}


