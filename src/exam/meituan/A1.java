package exam.meituan;

import java.util.HashSet;
import java.util.Scanner;

public class A1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            degree[i] = scan.nextInt();
        }
        System.out.println(getDegree(degree));
    }

    static int getDegree(int[] degree) {
        // 定义dp
        int[] dp = new int[degree.length];
        // base case
//        dp[0] = 0;

        HashSet<Integer> set = new HashSet<>();
        set.add(degree[0]);

        // 转移
        for (int i = 1; i < degree.length; i++) {
            int diff = 0;
            for (Integer s : set) {
                if (degree[i] > s) {
                    diff++;
                } else
                    break;
            }

            dp[i] = dp[i - 1] + diff;
            set.add(degree[i]);
        }
        return dp[degree.length - 1];
    }
}
