package LeetCode;

public class A5_LongestPalindrome {
    public static void main(String[] args) {

    }

    // 注意区别 最长回文子序列：LeetCode_516 动态规划

    /**
     * 最长回文子串：
     * 解法1：动态规划，
     * 值得一提的是，这个问题可以用动态规划方法解决，时间复杂度一样 O(N^2)，
     * 但是空间复杂度至少要 O(N^2) 来存储 DP table。这道题是少有的动态规划非最优解法的问题
     * 解法2：中心扩撒法
     * https://labuladong.gitbook.io/algo/mu-lu-ye-4/zui-chang-hui-wen-zi-chuan
     */
    // 中心扩散法
    public String longestPalindrome2(String s) {
        int[] res = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] s1 = palindrome(s, i, i); // 以 s[i] 为中心的最长回文子串
            int[] s2 = palindrome(s, i, i + 1); // // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            res = res[1] - res[0] > s1[1] - s1[0] ? res : s1;
            res = res[1] - res[0] > s2[1] - s2[0] ? res : s2;
        }
        return s.substring(res[1], res[0]);
    }

    int[] palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l + 1, r};
    }


    // 动态规划
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示s[i ... j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        //
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等
                    // 考虑头尾去掉之后，如果只要一个字符或没有字符，是回文串
                    // j - i + 1 - 2 < 2
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        // 是否是回文串，取决于s[i+1 : j-1]是否是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 记录回文串位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 时间复杂度：n^2
    // 空间复杂度：n^2
}

