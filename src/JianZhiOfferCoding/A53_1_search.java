package JianZhiOfferCoding;

// 在排序数组中查找数字出现的次数
public class A53_1_search {
    public static void main(String[] args) {

        A53_1_search solution = new A53_1_search();
        int search = solution.search2(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(search);
    }

    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int m;
        while (i <= j) {
            m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        return i;
    }

    // 二分查找
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target)
                i = m + 1;
            else
                j = m - 1;
        }
        int right = i;
        System.out.println("right = " + right);

        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        System.out.println("left = " + left);
        return right - left - 1;
    }

    // 左右双指针，(慢)
    public int search3(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == target && nums[j] == target) {
                break;
            }
            if (nums[i] < target) i++;
            if (nums[j] > target) j--;
        }
        return i <= j ? j - i + 1 : 0;
    }

}

