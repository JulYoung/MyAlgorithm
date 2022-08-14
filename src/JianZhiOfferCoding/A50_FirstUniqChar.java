package JianZhiOfferCoding;

import java.util.HashMap;

// 第一个只出现一次的字符
public class A50_FirstUniqChar {
    public static void main(String[] args) {

    }

    static class solution {
        public char firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            HashMap<Character, Boolean> hashMap = new HashMap<>();
            for (char c : chars) {
                hashMap.put(c, !hashMap.containsKey(c));
            }
            for (char c : chars) {
                if (hashMap.get(c)) return c;
            }
            return ' ';
        }
    }
}

