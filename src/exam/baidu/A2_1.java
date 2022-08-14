package exam.baidu;

import java.util.Scanner;

// 73
public class A2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() - 1;

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = k + 1; i < n; i++) {
            if (nums[i] > 1) {
                right += nums[i];
            } else if (nums[i] == 1) {
                right += nums[i];
                break;
            } else {
                break;
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            if (nums[i] > 1) {
                left += nums[i];
            } else if (nums[i] == 1) {
                left += nums[i];
                break;
            } else {
                break;
            }
        }
        if (nums[k] == 1) {
            sum = Math.max(left, right) + nums[k];
        } else if (nums[k] > 1) {
            sum = left + right + nums[k];
        }

        System.out.println(sum);
    }
}
