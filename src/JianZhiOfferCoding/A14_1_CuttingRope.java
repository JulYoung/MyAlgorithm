package JianZhiOfferCoding;

// 剪绳子，贪心，更多的3
public class A14_1_CuttingRope {
    public static void main(String[] args) {
        int a = 4;
        ;

    }

    static class Solution {
        public int cuttingRope(int n) {
            if (n < 2)
                return 0;
            if (n == 2 || n == 3)
                return n - 1;
            int a = n / 3;  // 商
            int b = n % 3;  // 余数

            if (b == 0)
                return (int) Math.pow(3, a);
            if (b == 1)
                return (int) Math.pow(3, a - 1) * 4;
            return (int) Math.pow(3, a) * 2;

        }
    }

}
