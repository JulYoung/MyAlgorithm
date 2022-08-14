package exam.meituan;

import java.util.HashMap;
import java.util.Scanner;

// 在文件流中找目标字符串所浪费的字符数
// 文件流为str，如: meituan 会行程meituanmeituan...的文件流
// tar为目标字符。如uta.
// 示例：输入：meituan uta
// 输出 10
public class A3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String tar = scan.next();
        int res = find(str, tar);
        System.out.println(res);
    }
    static int find(String str, String tar) {
        HashMap<Character, Integer> map = new HashMap<>();
        int idx = -1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), i);
        }
        for (int i = 0; i < tar.length(); i++) {
            if (map.containsKey(tar.charAt(i))) {
                if (map.get(tar.charAt(i)) > idx) {
                    res += map.get(tar.charAt(i)) - idx - 1;
                } else {
                    res += str.length() - idx - 1 + map.get(tar.charAt(i));
                }
                idx = map.get(tar.charAt(i));
            } else {
                return -1;
            }
        }
        return res;
    }
}