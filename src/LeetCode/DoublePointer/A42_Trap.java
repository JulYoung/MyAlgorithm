package LeetCode.DoublePointer;

public class A42_Trap {
    public static void main(String[] args) {

    }
    // 接雨水问题
    // 左右双指针，
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        //
        int lmax = height[left];
        int rmax = height[right];

        int res = 0;
        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if (lmax < rmax) {
                res += lmax - height[left];
                left++;
            } else {
                res += rmax - height[right];
                right--;
            }
        }
        return res;
    }
}
