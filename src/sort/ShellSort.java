package sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {  // 增量
            // 在该增量下进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int N = 2000;
        int[] arr = {10, 8, 4, 7, 6, 3};
        ShellSort.shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}