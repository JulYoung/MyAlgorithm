package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        /* 测试快速排序 */
        int[] arr = {1, 9, 5, 6, 8, 3, 0};
        System.out.println(Arrays.toString(arr));
        heapSort(arr, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    // 节点位置的调整
    static void sift(int[] arr, int low, int high) {

        int i = low;  // 父节点
        int j = 2 * i + 1;  // 左子节点
        int temp = arr[i];

        while (j <= high) {

            // 比较左子节点和右子节点的大小，让j指向大者。j < high表示有右子节点
            if (j + 1 <= high && arr[j] < arr[j + 1]) {
                j++;
            }

            // 比较子节点与父节点大小
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
                j = 2 * i + 1;
            } else  // 已经保证了大的为父节点
                break;
        }
        arr[i] = temp;
    }

    // 堆排序
    static void heapSort(int[] arr, int n) {

        // 1 建立初始大顶堆
        for (int i = n / 2; i >= 0; i--) {
            sift(arr, i, n);
        }

        // 2 堆排序：选择排序类型，选择最大值放在末尾。
        for (int i = n; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sift(arr, 0, i - 1);  // 重新调整
        }
    }

}
