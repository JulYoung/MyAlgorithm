package exam.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 9
public class A1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = new int[T];
        for (int i = 0; i < nums.length; i++) {

            for (int j = 6; ; j++) {
                int cnt = 2;  // 任何都包括1和本身
                boolean flag = true;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(j);
                for (int k = 2; k <= Math.sqrt(j); k++) {
                    if (j % k == 0) {
                        cnt += 2;
                        if (!isValid(list, nums[i], k, j / k)) {
                            flag = false;
                            break;
                        }
                        list.add(k);
                        list.add(j / k);

                    }
                }
                if (cnt >= 4 && flag) {
                    res[i] = j;
                    break;
                }
            }
        }
        for (int i : res) {
            System.out.println(i);
        }
    }

    static boolean isValid(List<Integer> list, int tar, int a, int b) {
        if (Math.abs(a - b) < tar) return false;
        for (Integer i : list) {
            if (Math.abs(a -  i) < tar || Math.abs(b - i) < tar) {
                return false;
            }
        }
        return true;
    }
}
