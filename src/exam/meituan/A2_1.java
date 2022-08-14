package exam.meituan;

import java.util.PriorityQueue;
import java.util.Scanner;

// 每本书有厚度，书架有宽度
// 将每本书放入书架，有多少中放法
// 示例输入：
// 4
// 1 2 3 4
// 2 4 3 4
// 输出：8
public class A2_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();

        PriorityQueue<Integer> thickness = new PriorityQueue<>(); // 默认小顶堆
        PriorityQueue<Integer> width = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            thickness.add(scan.nextInt());
        }

        for (int i = 0; i < n; i++) {
            width.add(scan.nextInt());
        }

        long ans = 1;
        long ia = 0;
        int ib = 0;
        while (ia <= n && ib < n) {
            if (thickness.isEmpty()) {
                ans *= (ia - ib) % 1000000007;
//                System.out.println(ans);
                width.poll();
                ib++;
            } else  {
                if (thickness.peek() <= width.peek()) {  // 可以放下
                    thickness.poll();
                    ia++;
                } else {
                    ans *= (ia - ib) % 1000000007;
//                    System.out.println(ans);
                    width.poll();
                    ib++;
                }
            }
        }
        System.out.println(ans);
    }
}
