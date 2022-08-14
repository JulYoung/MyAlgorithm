package JianZhiOfferCoding;

// 快速幂运算
public class A16_Power {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(5, 2));

    }

    static class Solution {
        public double myPow(double x, int n) {
            double res = 1.0;
            long a = n;
            // x = 0 的情况
            if (x == 0)
                return 0;
            if (x == 1)
                return 1.0;
            if (n < 0)  { // n 小于0的情况
                x = 1 / x;
                a = -a;
            }

            // 快速幂运算
            while (a > 0) {
                if ((a  & 0x01) == 1) {  // n 为单数
                    res *= x;
                }
                x *= x;
                a >>= 1;  // n 除2
            }
            return res;
        }

    }

}
