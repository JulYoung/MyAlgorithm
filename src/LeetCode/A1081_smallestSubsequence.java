package LeetCode;

import java.util.Stack;

// 不同字符的最小子序列
//      与LeetCode316移除重复字母一样
public class A1081_smallestSubsequence {
    public static void main(String[] args) {

    }

    // 求字典序最小子序列，实则为去重 + 保证字典序最小
    // 访问每个字符，将其入栈
    // 判断出栈：栈不空 且 当前字符 > 栈顶，则判断是否需要出栈。
    // 是否需要出栈：栈顶元素后续不会出现了，不出栈，反之出栈。
    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];  // 字符出现的次数
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        boolean[] inStack = new boolean[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']--; // 出现次数减一

            // 存在栈中，无需后续判断
            if (inStack[ch - 'a'])
                continue;

            // 出栈
            while (!stack.isEmpty() && ch < stack.peek()) {
                // 栈顶元素不会出现，不出栈
                if (cnt[stack.peek() - 'a'] == 0) {
                    break;
                }
                // 后续还有，出栈
                char temp = stack.pop();  // 出栈
                inStack[temp - 'a'] = false;
            }

            // 入栈
            stack.push(ch);
            inStack[ch - 'a'] = true;
        }
        StringBuilder strb = new StringBuilder();
        while (!stack.isEmpty()) {
            strb.append(stack.pop());
        }
        return strb.reverse().toString();

    }
}
