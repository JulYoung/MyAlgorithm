package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A921_MinAddToMakeValid {
    public static void main(String[] args) {
        A921_MinAddToMakeValid so = new A921_MinAddToMakeValid();
        int i = so.minAddToMakeValid("())");
        System.out.println(i);

    }

    // 优化：https://labuladong.gitbook.io/algo/mu-lu-ye-4/kuo-hao-cha-ru#ping-heng-kuo-hao-chuan-yi
    public int minAddToMakeValid(String s) {
        if (s.length() < 2) return s.length();
        int res = 0;
        int need = 0; // 记录右括号的需求量
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                need++;
            } else {  // ')'
                if (need > 0) {
                    need--;
                } else {
                    res++;
                }
            }
        }
        return res + need;
    }

    /*  借鉴LeetCode20，利用栈和map结构，
     *  但是本题只有一种类型的括号，所以一刻优化不用栈结构
     */
    public int minAddToMakeValid2(String s) {
        if (s.length() < 2)
            return s.length();
        int res = 0;
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
        }};
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                // 左括号加入
                stack.push(ch);
            } else {
                //
                if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
                    stack.pop();
                } else {
                    res++;
                }
            }
        }
        return res + stack.size();
    }
}

