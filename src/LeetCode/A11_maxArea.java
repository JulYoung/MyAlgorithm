package LeetCode;

public class A11_maxArea {
    public static void main(String[] args) {
        Solution solution = new Solution();


    }

    static class Solution {

        // 双指针
        public int maxArea(int[] height) {
            int res = 0;
            int i = 0;
            int j = height.length - 1;
            while (i < j) {
                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
            return res;
        }
    }

}

