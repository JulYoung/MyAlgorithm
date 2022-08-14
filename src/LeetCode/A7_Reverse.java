package LeetCode;

public class A7_Reverse {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int reverse(int x) {
            int res = 0;

            while (x != 0) {
                int temp = x % 10;

                // 判断是否越界
                // 判断是否越界固定格式
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return 0;
                }

                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                    return 0;
                }

                res = res * 10 + temp;
                x /= 10;
            }

            return res;
        }

    }

}

