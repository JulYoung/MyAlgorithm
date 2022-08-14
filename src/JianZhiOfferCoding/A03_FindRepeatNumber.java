package JianZhiOfferCoding;

public class A03_FindRepeatNumber {

    public static void main(String[] args) {
        A03_FindRepeatNumber so = new A03_FindRepeatNumber();
        int[] nums =  new int[]{3, 4, 2, 0, 0, 1};
        System.out.println(so.findRepeatNumber(nums));
    }


    // 方法1：使用HashSet，但空间复杂度为O(n)
    // 方法2：分析题目，长度为n的数组的所有数字都在0-(n-1)里。所以可以用将索引与值对应起来。此时空间复杂度为1
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i])
                continue;
            // 交换
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i])
                    return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}

