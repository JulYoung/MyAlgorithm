package JianZhiOfferCoding;

import java.util.Stack;

// 栈的压入、弹入序列
public class A31_ValidateStackSequences {
    public static void main(String[] args) {

    }

    static class Solution {
        // 模拟
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int x = 0;
            for (int a : pushed) {
                stack.push(a);
                while (!stack.isEmpty() && stack.peek() == popped[x]) {
                    stack.pop();
                    x++;
                }
            }
            return stack.isEmpty();
        }
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */