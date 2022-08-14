package exam.tencent;

import java.util.ArrayList;
import java.util.Scanner;

// 通过100%
public class A1_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            slove(nums[i]);
        }
    }

    static void slove(int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = target + 1; ; i++) {
            int flag = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag != 0) {
                list.add(i);
                break;
            }
        }
        for (int i = list.get(list.size() - 1) + target; ; i++) {
            int flag = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag != 0) {
                list.add(i);
                break;
            }
        }
        System.out.println(Math.min((long) list.get(0) * list.get(1), (long) Math.pow(list.get(0), 3)));
    }
}
