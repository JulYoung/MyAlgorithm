package Algorithm;

import java.util.PriorityQueue;

/**
 * 在数据流中，找中位数. 设计一个数据结构。
 *      不能每次插入时排序，时间复杂度太高
 *      利用堆（优先级队列）解决
 */

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;  // 大顶堆存前半部分，所以顶最大
    PriorityQueue<Integer> minHeap;  // 小顶推存后半部分

    public MedianFinder() {
        minHeap = new PriorityQueue<>();  // 小顶堆
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        // 大小相等，往大顶堆添加
        if (maxHeap.size() == minHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty())
            return 0;
        //
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

}
