package exam.tencent;

import java.util.Arrays;
import java.util.Scanner;

// 通过 66.67%
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }

            int[] res = new int[n];

            for (int j = 0; j < n; j++) {
                int idx = j;
                int sum = 0;
                while (idx < n) {
                    sum += nums[idx];
                    idx += nums[idx];
                }
                res[j] = sum;
            }
            Arrays.sort(res);
            System.out.println(res[n - 1]);
        }
    }
}
