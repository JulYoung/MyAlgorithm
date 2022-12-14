package JianZhiOfferCoding;

// 求第n个丑数
public class A49_UglyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));

    }

    static class Solution {
        // 方法：动态规划，三个指针。所有丑数均是2或3或5的倍数
        public int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = dp[a] * 2;
                int n3 = dp[b] * 3;
                int n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (dp[i] == n2) a++;
                if (dp[i] == n3) b++;
                if (dp[i] == n5) c++;
            }
            return dp[n - 1];
        }
    }
}


