package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        /* 测试快速排序 */
        int[] arr = {4, 3, 9, 3, 6, 8, 3, 0};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // 快速排序
    static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int i = left, j = right;
        int temp = arr[left];
        while (i < j) {
            // 找到右边小于轴的索引
            while (i < j && arr[j] >= temp)
                j--;
            // 与换到左边
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            // 找左边
            while (i < j && arr[i] < temp)
                i++;
            if (i < j) {
                arr[j] = arr[i];  // 换到右边
                j--;
            }
        }
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    // 快速排序(优解)
    static void quickSort2(int[] arr, int left, int right) {
        int i = left, j = right;
        if (left < right) {
            int temp = arr[left];
            while (i < j) {
                // 找到右边严格小于轴的索引
                while (i < j && arr[j] >= temp) j--;
                // 找到左边严格大于轴的索引
                while (i < j && arr[i] <= temp) i++;
                if (i < j)
                    swap(arr, i, j);  // 交换
            }
            swap(arr, i, left);  // 与轴交换
            quickSort2(arr, left, i - 1);
            quickSort2(arr, i + 1, right);
        }
    }

    // 快速排序 + 随机轴
    static void quickSort3(int[] arr, int left, int right) {
        int i = left, j = right;
        if (left < right) {
            // 选取随机轴
            int rand = new Random().nextInt(right - left + 1) + left;
            swap(arr, left, rand);
            int temp = arr[left];

            while (i < j) {
                // 找到右边严格小于轴的索引
                while (i < j && arr[j] >= temp) j--;
                // 找到左边严格大于轴的索引
                while (i < j && arr[i] <= temp) i++;
                if (i < j)
                    swap(arr, i, j);  // 交换
            }
            swap(arr, i, left);  // 与轴交换

            quickSort3(arr, left, i - 1);
            quickSort3(arr, i + 1, right);
        }
    }



    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
