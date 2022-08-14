package JianZhiOfferCoding;

public class A10_Fibonacci {
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            System.out.println(i + "  " + new Solution().fib(i));
        }

    }


    static class Solution {
        public int fib(int n) {
            if (n <= 1) {
                return n;
            }
            int fibNMinusOne = 1;
            int fibNMinusTwo = 0;
            int fibN = 0;
            for (int i = 2; i <= n; i++) {
                fibN = (fibNMinusOne + fibNMinusTwo) % 1000000007;
                fibNMinusTwo = fibNMinusOne;
                fibNMinusOne = fibN;
            }
            return fibN;
        }
    }
}

