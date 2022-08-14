package LeetCode.dp;

public class A516_longestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(10 % 8);
        System.out.println(10 & 7);
        System.out.println(15 / 8);
        System.out.println(15 >> 3);
    }

    static class Solution {
        // 最长回文子序列
        // 注意区别最长回文子串：LeetCode-5
        public int longestPalindromeSubseq(String s) {
            // 难点：定义DP
            // 定义DP，dp[i][j]: 表示s[i...j]这个子串的最长回文子序列
            int len = s.length();
            int[][] dp = new int[len][len];

            // base case
            // i < j, dp = 0;
            // i == j, dp == 1;
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
            }

            // 转移
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        // 如果它俩不相等，说明它俩不可能同时出现在s[i..j]的最长回文子序列中，
                        // 那么把它俩分别加入s[i+1..j-1]中，看看哪个子串产生的回文子序列更长即可：
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }

}

