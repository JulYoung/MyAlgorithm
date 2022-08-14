package JianZhiOfferCoding;

// 排序数组中两数之和
public class A57_TwoSum {
    public static void main(String[] args) {

    }

    // 左右双指针
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else break;
        }
        if (i != j)
            return new int[]{nums[i], nums[j]};
        return new int[0];
    }

}

