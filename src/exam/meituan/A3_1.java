package exam.meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A3_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String tar = scan.next();

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, 1);
        }
        for (Character ch :tar.toCharArray()) {
            if (!map.containsKey(ch)) {
                System.out.println(-1);
                break;
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
            map.put(str.charAt(i), i);
        }
        int res = 0;
        int len = tar.length();
        int temp = -1;
        for (int i = 0; i < len; i++) {
            int temp2 = map.get(tar.charAt(i));
            res += (temp2 - temp + str.length()) % str.length() - 1;
            temp = temp2;
        }
        System.out.println(res);
    }
}