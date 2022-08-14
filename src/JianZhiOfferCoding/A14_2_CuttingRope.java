package JianZhiOfferCoding;

// 剪绳子，循环求余
public class A14_2_CuttingRope {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long remand = solution.remainder2(3, 40, 1000000007);
        System.out.println(remand);
        System.out.println(solution.cuttingRope(120));
        System.out.println(solution.cuttingRope2(120));

    }

    static class Solution {
        public int cuttingRope(int n) {
            if (n < 2)
                return 0;
            if (n == 2 || n == 3)
                return n - 1;
            int a = n / 3;  // 商
            int b = n % 3;  // 余数
            int mod = 1000000007;

            long rem = remainder2(3, a - 1, mod);
            System.out.println("rem = " + rem);

            if (b == 0)
                return (int) (rem * 3 % mod);
            if (b == 1)
                return (int) (rem * 4 % mod);
            return (int) (rem * 6 % mod);
        }

        // 循环求余，防止大数越界
        public long remainder(int x, int a, int mod) {
            long rem = 1;  // 因为要先乘法，所以需要long
            for (int i = 1; i <= a; i++) {
                rem = (rem * x) % mod;
            }
            return rem;
        }

        // 循环求余，防止大数越界
        public long remainder2(int x, int a, int mod) {
            long rem = 1;  // 因为要先乘法，所以需要long
            long  y = x;
            for (int i = a; i > 0; i /= 2) {
                if (i % 2 == 1)
                    rem = (rem * y) % mod;
                y = (y * y) % mod;
            }
            return rem;
        }

        public int cuttingRope2(int n) {
            if (n <= 3) return n - 1;
            int b = n % 3, p = 1000000007;
            long rem = 1, x = 3;
            for (int a = n / 3 - 1; a > 0; a /= 2) {
                if (a % 2 == 1) rem = (rem * x) % p;
                x = (x * x) % p;
            }
            System.out.println("rem = " + rem);
            if (b == 0) return (int) (rem * 3 % p);
            if (b == 1) return (int) (rem * 4 % p);
            return (int) (rem * 6 % p);
        }

    }

}
