package JianZhiOfferCoding;

// 正则表达式匹配
public class A19_RegularExpressionsMatching {
    public static void main(String[] args) {


    }
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        // base case
        dp[0][0] = true;
        for (int j = 2; j < n; j++) {
            dp[0][j] = (p.charAt(j - 2) == '*') && dp[0][j - 2];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2])
                        dp[i][j] = true;  // 1. * 前面字符出现0次
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2))
                        dp[i][j] = true;  // 2. 让字符p[j-2]多出现1次时，能否匹配。
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.')
                        dp[i][j] = true;  // 3. 即让字符 . 多出现一次时
                } else {
                    // 当前字符相同，或者p的当前字符为'.'。则取决于dp[i - 1][j - 1]能否匹配
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt( j -1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2])
                        dp[i][j] = true;  // 1. * 前面字符出现0次
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2))
                        dp[i][j] = true;  // 2. 让字符p[j-2]多出现1次时，能否匹配。
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.')
                        dp[i][j] = true;  // 3. 即让字符 . 多出现一次时
                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1))
                        dp[i][j] = true;  // 1. 前 i-1 和 j-1 字符匹配，并且，当前字符相等，则为true
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.')
                        dp[i][j] = true;  // 2. 前 i-1 和 j-1 字符匹配，并且模式串的字符为'.'，则为true
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

