package LeetCode;

// 1541. 平衡括号字符串的最少插入次数
// https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
public class A1541_MinInsertions {
    public static void main(String[] args) {
        A1541_MinInsertions so = new A1541_MinInsertions();
        System.out.println(so.minInsertions("(()))(()))()())))"));
    }

    // 解法
    public int minInsertions(String s) {
        int ans = 0, left = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                ++left; // 左括号次数
            else {  // 右括号
                if (i + 1 < n && s.charAt(i + 1) == ')')
                    ++i; // 找第二个左括号
                else
                    ++ans; // 缺少第二个右括号就添加一个
                if (left > 0)
                    --left;   // 两个右括号匹配一个左括号
                else
                    ++ans; // 缺少左括号就添加一个
            }
        }
        ans += left * 2;  // 多出的左括号都匹配两个右括号
        return ans;
    }
}

