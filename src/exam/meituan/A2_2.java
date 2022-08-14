package exam.meituan;

import java.util.Arrays;
import java.util.Scanner;

// 每本书有厚度，书架有宽度
// 将每本书放入书架，有多少中放法
// 示例输入：
// 4
// 1 2 3 4
// 2 4 3 4
// 输出：8
public class A2_2 {
    // 降序排序
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();

        Integer[] thickness = new Integer[n];
        Integer[] width = new Integer[n];

        for (int i = 0; i < n; i++) {
            thickness[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            width[i] = scan.nextInt();
        }

        Arrays.sort(thickness, (o1, o2) -> o2 - o1);
        Arrays.sort(width, (o1, o2) -> o2 - o1);

        int idx = 0;
        int res = 1;
        for (int i = 0; i < n; i++) {
            while (idx < n && width[idx] >= thickness[i]) {
                idx++;
            }
            res = res * (idx - i) % 1000000007;
        }

        System.out.println(res);
    }
}
