package JianZhiOfferCoding;

import java.util.Stack;

// 顺时针打印矩阵
public class A30_MinStack {
    public static void main(String[] args) {
        A30_MinStack so = new A30_MinStack();
        so.push(10);
        so.push(5);
        so.push(15);
        System.out.println(so.min());
    }

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    // 利用辅助站
    Stack<Integer> helperStack = new Stack<>();
    public A30_MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (helperStack.isEmpty() || x <= helperStack.peek()) {
            helperStack.push(x);
        }
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == helperStack.peek()) {
            helperStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helperStack.peek();
    }
}
