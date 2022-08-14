package LeetCode.SlidingWindow;

import java.util.HashMap;


/**
 * 滑动窗口问题
 * 现在开始套模板，只需要思考以下四个问题：
 * 1、当移动 right 扩大窗口，即加入字符时，应该更新哪些数据？
 * 2、什么条件下，窗口应该暂停扩大，开始移动 left 缩小窗口？
 * 3、当移动 left 缩小窗口，即移出字符时，应该更新哪些数据？
 * 4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
 */

public class A76_MinWindow {

    // 如果一个字符进入窗口，应该增加 window 计数器；如果一个字符将移出窗口的时候，应该减少 window 计数器；
    // 当 valid 满足 need 时应该收缩窗口；应该在收缩窗口的时候更新最终结果。
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();  //
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 1. 增大窗口, 考虑更新哪些数据
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 2. 收缩窗口, 考虑何时收缩窗口，更新哪些数据，
            while (valid == need.size()) {
                // 记录当前窗口。即结果
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 收缩
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    // 滑动窗口框架
    public String minWindow2(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            right++; // 右移窗口

            /* 进行窗口内数据的更新 */

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;

                /* 进行窗口内数据的更新 */
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
