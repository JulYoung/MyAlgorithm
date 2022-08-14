package LeetCode;

public class A8_isPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int a = -100;
        System.out.println(Integer.toString(a));

    }

    static class Solution {
        // 解法1：转为字符串
        public boolean isPalindrome(int x) {
            String s = Integer.toString(x);
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

        // 解法2：数学法，每次取首尾
        // 解法3：反转后半段
        public boolean isPalindrome3(int x) {
            if (x < 0 || (x % 10 ==0 && x!= 0)) return false;
            int rev = 0;
            while (x > rev) {
                int temp = x % 10;
                rev = rev * 10 + temp;
                x /= 10;
            }
            return x == rev || x == rev / 10;
        }
    }

}

