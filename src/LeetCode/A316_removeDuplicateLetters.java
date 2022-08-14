package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

// 去除重复的字母
public class A316_removeDuplicateLetters {
    public static void main(String[] args) {

    }

    // 去重 + 保证最小字典序。因此需要考虑删除哪个重复的才能使字典序最小
    // 利用单调栈保证字典序：在小于栈顶时，并后续有重复字母时，考虑弹出。
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        boolean[] inStack = new boolean[26];
        Deque<Character> deque = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']--; //
            //
            // 若当前字符存在于栈中，则不需要出栈入栈判断
            if (inStack[ch - 'a']) {
                continue;
            }

            // 出栈判断，保证字典序
            while (!deque.isEmpty() && ch < deque.peekLast()) {
                // ch 小于栈顶，那么可能会出现ba..b的情况，此时a..b比ba的字典序要小。
                // 若字符串中之后不存在栈顶元素了，则停止 pop
                if (cnt[deque.peekLast() - 'a'] == 0) {
                    break;
                }
                // 之后还有，可以pop，并在inStack中删除
                inStack[deque.pollLast() - 'a'] = false;
            }
            // 入栈
            deque.addLast(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder strb = new StringBuilder();
        while (!deque.isEmpty()) {
            strb.append(deque.pollFirst());
        }
        return strb.toString();
    }

}
