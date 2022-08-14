package sort;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 默认小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }

}
