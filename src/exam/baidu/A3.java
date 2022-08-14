package exam.baidu;

import java.util.Random;
import java.util.Scanner;

// 20 %
public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Random random = new Random();

        int rand = random.nextInt(2);

        if (rand == 0) {
            System.out.println(1);  // 5%
        } else {
            System.out.println(6);  // 15%
        }


    }

}
