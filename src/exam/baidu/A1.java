package exam.baidu;

import java.util.Scanner;

// 100%
public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += sc.nextInt();
            }
        }
        System.out.println(sum);
    }

}
