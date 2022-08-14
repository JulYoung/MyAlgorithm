package exam;

import java.util.Scanner;

public class HuaweiQ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(N);
        System.out.println(K);
        int[][] time = new int[K][2];
        int startTime = 0, endTime, startStation = 0, endStation = 0, path;
        int[] cnt = new int[1001];
        for (int i = 0; i < K; i++) {

            startTime = scanner.nextInt();
            startStation = scanner.nextInt();
            endStation = scanner.nextInt();
            System.out.println(startTime + startStation + endStation);
            if (startStation == endStation) {
                continue;
            }
            path = Math.abs(endStation - startStation);
            path = (path > (N >> 1) ? N - path : path);
            endTime = startTime + path * 5;
            for (int j = startTime; j < endTime; j++) {
                cnt[j]++;
            }

        }
        int max = 0;
        for (int i = 0; i < 1001; i++) {
            max = Math.max(max, cnt[i]);
        }

        System.out.println(max);
    }
}
