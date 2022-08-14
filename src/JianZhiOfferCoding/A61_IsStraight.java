package JianZhiOfferCoding;

import java.util.HashSet;

public class A61_IsStraight {
    public static void main(String[] args) {

    }


    public boolean isStraight(int[] nums) {
        int max = 0, min = 14;
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            // 跳过大小王
            if (num == 0) continue;

            // 重复直接返回
            if (hashSet.contains(num)) return false;
            hashSet.add(num);

            // 求最大最小值
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }

}

