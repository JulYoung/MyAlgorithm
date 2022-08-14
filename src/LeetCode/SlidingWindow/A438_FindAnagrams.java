package LeetCode.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 滑动窗口问题
 * 现在开始套模板，只需要思考以下四个问题：
 * 1、当移动 right 扩大窗口，即加入字符时，应该更新哪些数据？
 * 2、什么条件下，窗口应该暂停扩大，开始移动 left 缩小窗口？
 * 3、当移动 left 缩小窗口，即移出字符时，应该更新哪些数据？
 * 4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
 */

public class A438_FindAnagrams {
    public static void main(String[] args) {
        A438_FindAnagrams solution = new A438_FindAnagrams();
        List<Integer> anagrams = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }


    // 明确为滑动窗口问题；
    // 找p在s中的排列串；即判断窗口内是否包含p的全部字符, 需要考虑重复字符
    // 所以考虑用map结构存储p中每个字符出现的频率。
    // 再用一个map结构存储窗口内的字符频率
    // 用int变量valid表示匹配成功的字符
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) { // [left, right)
            // 1. 增大窗口
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 2. 减小窗口
            if (right - left >= p.length()) {
                if (valid == need.size()) {  // 匹配成功
                    res.add(left);
                }

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
        return res;
    }
}
