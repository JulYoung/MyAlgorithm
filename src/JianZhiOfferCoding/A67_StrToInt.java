package JianZhiOfferCoding;

public class A67_StrToInt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strToInt("9223372036854775808");
        System.out.println(i);


    }

    static class Solution {
        public int strToInt(String str) {
            String s = str.trim();
            if (s.length() == 0) return 0;
            if ((s.charAt(0) < '0' || s.charAt(0) > '9') && s.charAt(0) != '-' && s.charAt(0) != '+') {
                return 0;
            }

            long res = 0;
            boolean isNegative = false;
            int i = 0;
            if (s.charAt(0) == '-') {
                isNegative = true;
                i = 1;
            } else if (s.charAt(0) == '+') {
                i = 1;
            }

            for (; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    break;
                }

                res *= 10;
                res += s.charAt(i) - '0';
                if (res > (long) Integer.MAX_VALUE + 1) break;
            }

            if (isNegative) {
                res *= -1;
            }

            if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int)res;

        }
    }
}

