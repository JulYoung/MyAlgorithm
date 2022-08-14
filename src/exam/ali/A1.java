package exam.ali;

import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] data = new int[t][2];
        for (int i = 0; i < t; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        int[] solve = solve(data);
        for (int s : solve) {
            System.out.println(s);
        }

    }

    static int[] solve(int[][] data) {
        int[] res = new int[data.length];
        int n, k;
        for (int i = 0; i < data.length; i++) {
            n = data[i][0];
            k = data[i][1];
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n ; l++) {
                    if (j % l == k) {
                        cnt++;
                    }
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}

