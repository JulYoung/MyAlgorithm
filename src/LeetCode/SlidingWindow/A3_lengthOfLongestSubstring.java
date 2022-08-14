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
public class A3_lengthOfLongestSubstring {


    // 明确为滑动窗口问题。
    // 利用map结构存储处于窗口内的字符出现的频率
    // 增大窗口，记录频率
    // 如果当前增加的字符频率大于1，则循环减小窗口，直至频率等于1
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            // 增大
            char ch = s.charAt(right);
            right++;

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // 减小
            while (window.get(ch) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
