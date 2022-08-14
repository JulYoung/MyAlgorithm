package exam.xiaomi;

import java.util.Scanner;

// 红白蓝彩条排序
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = solve(arr);

        for (int r : res) {
            System.out.print(r + " ");
        }
    }
    static int[] solve(int[] arr) {
        int[] res = new int[10];

        int left = 0, right = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                res[left++] = 1;
            } else if (arr[i] == 3) {
                res[right--] = 3;
            }
        }

        for (int i = left; i <= right; i++) {
            res[i] = 2;
        }
        return res;
    }
}
