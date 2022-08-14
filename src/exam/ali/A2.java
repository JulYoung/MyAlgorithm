package exam.ali;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 类似力扣491
// 计算数列中长度不超过 k 的严格递增子序列
// 输入：
//    5 2           // 5代表数组长度，2代表k
//    1 2 3 4 2
// 输出：
//    12
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solve(arr, k, 0);
        System.out.println(lists);
        System.out.println(lists.size());
    }
    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static long res = 0;
    static void solve(int[] arr, int k, int cur) {
        if (cur > arr.length || path.size() > k) {
            return;
        }
        if (!path.isEmpty()) {
            lists.add(new ArrayList<>(path));
        }
        for (int i = cur; i < arr.length; i++) {
            if (!path.isEmpty() && arr[i] <= path.peekLast()) {
                continue;
            }
            path.addLast(arr[i]);

            solve(arr, k, i + 1);

            path.removeLast();

        }
    }
}

