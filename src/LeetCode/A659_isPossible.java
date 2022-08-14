package LeetCode;

import java.util.HashMap;

public class A659_isPossible {
    public static void main(String[] args) {
        A659_isPossible so = new A659_isPossible();
        System.out.println(so.isPossible(new int[]{1, 2, 3, 4, 4, 5}));

    }

    // 659. 分割数组为连续子序列
    // 1) 判断当前元素是否可以加入到其他子序列
    // 2) 能否自成一派。
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();  // 记录频率
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // 对于序列[1,2,3]. 那么对4的需求为1, 因此4这个元素可以选择加入该序列。
        // 优先选择加入其他已存在的序列。
        HashMap<Integer, Integer> needs = new HashMap<>();

        for (int num : nums) {
            if (freq.get(num) == 0) continue;

            // 1) 是否可以加入其他序列
            if (needs.containsKey(num) && needs.get(num) > 0) {
                freq.put(num, freq.get(num) - 1);
                needs.put(num, needs.get(num) - 1);
                needs.put(num + 1, needs.getOrDefault(num + 1, 0) + 1);
            } else if (freq.getOrDefault(num, 0) > 0 &&
                    freq.getOrDefault(num + 1, 0) > 0 &&
                    freq.getOrDefault(num + 2, 0) > 0) {
                // 2) 是否可以自成一个序列
                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);

                needs.put(num + 3, needs.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}

