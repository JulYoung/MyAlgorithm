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
public class A567_CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            // 1. 增加窗口
            char c = s2.charAt(right);  // 增加的字符
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 2. 减小窗口
            while (right - left >= s1.length()) {
                // 减小之前的处理，即结果
                if (valid == need.size()) {
                    return true;
                }
                // 减少窗口
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }
}
