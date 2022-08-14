package exam.huaweiExam;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = scanner.nextInt();
        }
        int[] dp = new int[n];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 1; j <= dist[i] && i + j < dp.length; j++) {
                if (dp[i + j] == 0 || dp[i + j] > dp[i] + 1) {
                    dp[i + j] = dp[i] + 1;
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
