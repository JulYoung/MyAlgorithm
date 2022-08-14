package JianZhiOfferCoding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class A59_2_MaxQueue {
    public static void main(String[] args) {

    }

    static class MaxQueue {

        Queue<Integer> queue;  // 普通队列
        Deque<Integer> deque;  // 用作单调减队列

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);

            // 维持单调减结构
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.removeLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;

            if (queue.peek().equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return queue.isEmpty() ? -1 : queue.poll();
        }
    }
}

