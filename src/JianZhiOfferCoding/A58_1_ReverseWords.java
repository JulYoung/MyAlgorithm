package JianZhiOfferCoding;

import java.util.Stack;

public class A58_1_ReverseWords {
    public static void main(String[] args) {
        A58_1_ReverseWords solution = new A58_1_ReverseWords();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good   example"));


    }

    // 双指针
    public String reverseWords(String s) {
        s = s.trim();  // 去除两端的空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s, i + 1, j + 1).append(' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }

    // 单调栈太慢，不适合
    public String reverseWords2(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                stack.add(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (res.length() != 0) {
                    res.append(' ');
                }
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
            }
        }
        if (!stack.isEmpty()) {
            if (res.length() != 0) {
                res.append(' ');
            }
            while (!stack.isEmpty()) {
                res.append(stack.pop());
            }
        }

        return res.toString();
    }
}

