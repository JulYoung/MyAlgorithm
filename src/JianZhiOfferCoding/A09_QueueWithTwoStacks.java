package JianZhiOfferCoding;

import java.util.Stack;

// 利用两个栈实现队列
public class A09_QueueWithTwoStacks {
    public static void main(String[] args) {


    }

    static class CQueue {
        private Stack<Integer> stack1;  // 定义两个栈
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();  // java需要用new分配堆空间
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);  // 利用栈1在尾部添加
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {  // 如果栈2为空，则将栈1的元素全部出栈放到栈2
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {  // 如果此时栈2还为空，证明队中没有元素
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }
}

