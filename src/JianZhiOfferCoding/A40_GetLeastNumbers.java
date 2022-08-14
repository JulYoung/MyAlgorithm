package JianZhiOfferCoding;

import java.util.Arrays;
import java.util.PriorityQueue;

// 最小的k个数
public class A40_GetLeastNumbers {
    public static void main(String[] args) {
    }

    // topK问题:
    // 1. 使用快排思想
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

    public int[] quickSort(int[] arr, int l, int r, int k) {
        int i = l, j = r;
        int temp = arr[l]; // 哨兵
        while (i < j) {
            while (i < j && arr[j] >= temp) j--;
            while (i < j && arr[i] <= temp) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (k < i) return quickSort(arr, l, i - 1, k);
        if (k > i) return quickSort(arr, i + 1, r, k);
        return Arrays.copyOf(arr, k);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 2. 使用堆
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int a : arr) {
            if (pq.size() < k) {
                pq.offer(a);
            } else if (a < pq.peek()) {
                pq.poll();
                pq.offer(a);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (Integer integer : pq) {
            res[idx++] = integer;
        }
        return res;
    }


}


