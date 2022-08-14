package JianZhiOfferCoding;

// 数字序列中某一位数
public class A44_findNthDigit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(11));

    }
    static class Solution {
        public int findNthDigit(int n) {
            int digit = 1;  // 位数, 1, 2, 3, ...
            long start = 1;  // 位数开始的第一个数1, 10, 100, ...
            long count = 9;  // 该位数中所有位数之和9, 90, 900, ..., digit * start * 9

            // 1. 找第n位属于几位数中
            while (n > count) {
                n -= count;
                digit++;
                start *= 10;
                count = 9 * start * digit;
            }

            // 2. 找第n位属于哪个数字
            long num = start + (n - 1) / digit;

            // 3. 确定在num中哪一位
            String str = Long.toString(num);
            char c = str.charAt((n - 1) % digit);
            return c - '0';
        }
    }

}


