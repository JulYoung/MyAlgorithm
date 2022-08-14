package exam.meituan;

import java.util.Scanner;

public class A2 {
    // 回溯，时间复杂度不行，只通过18%
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();
        int[] thickness = new int[n];
        for (int i = 0; i < n; i++) {
            thickness[i] = scan.nextInt();
        }
        int[] width = new int[n];
        for (int i = 0; i < n; i++) {
            width[i] = scan.nextInt();
        }
        boolean[] used = new boolean[n];
        dfs(thickness, width, used, 0);
        System.out.println(res);
    }
    static long res = 0;

    static void dfs(int[] thickness, int[] width, boolean[] used, int k) {
        // 结束条件
        if (k == thickness.length) {
            res = (res + 1) % 1000000007;
            return;
        }

        // 选择列表
        for (int i = 0; i < width.length; i++) {
            if (thickness[k] > width[i])
                continue;
            if (used[i]) {
                continue;
            }
            used[i] = true;
            k++;

            dfs(thickness, width, used, k);
            used[i] = false;
            k--;
        }
    }
}
