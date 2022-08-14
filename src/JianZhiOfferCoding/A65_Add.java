package JianZhiOfferCoding;

public class A65_Add {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1; // a 和 b 相加产生的进位
                a ^= b;  // a 和 b 的不进位相加
                b = c;  // b 等于进位，下一次循环，会让不进位相加的和与进位产生加法。
            }
            return a;
        }
    }
}

