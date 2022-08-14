package JianZhiOfferCoding;

import java.util.HashMap;
import java.util.HashSet;

// 最长不含重复字符的子字符串
public class A48_LongestSubString {
    public static void main(String[] args) {
        A48_LongestSubString so = new A48_LongestSubString();
        int res = so.lengthOfLongestSubstring2("bbbbb");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int dp = 0;  // 状态转移
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int j = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);  // 更新索引表
            if (dp < i - j) {
                dp += 1;
            } else {
                dp = i - j;
            }
            res = Math.max(res, dp);
        }
        return res;
    }
    // 滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            // 增大窗口
            char ch = s.charAt(j);
            j++;
            // 减小窗口
            while (set.contains(ch)) {
                char d = s.charAt(i);
                set.remove(d);
                i++;
            }
            set.add(ch);
            res = Math.max(res, j - i);
        }
        return res;
    }
}


