package JianZhiOfferCoding;

// 二进制中的1的个数
public class A15_NumberOfInBinary {
    public static void main(String[] args) {


    }

    static class Solution {
        // 时间太长不合适
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count += n & 1;
                n >>= 1;
            }
            return count;
        }

        // n-1
        public int hammingWeight2(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }
            return count;
        }

        public int hammingWeight3(int n) {
            return Integer.bitCount(n);
        }

    }

}
