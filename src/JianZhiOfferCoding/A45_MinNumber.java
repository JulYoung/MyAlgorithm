package JianZhiOfferCoding;

import java.util.Arrays;

// 把数组排成最小的数
public class A45_MinNumber {
    public static void main(String[] args) {


    }

    // 利用sort方法
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        // 定制盘排序
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        // 拼接
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    // 自定义快排思想
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        // 对strs定制快速排序
        quickSort(strs, 0, strs.length - 1);

        // 拼接
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }

        return res.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        int i = l, j = r;
        if (l < r) {
            String temp = strs[l]; // 哨兵
            while (i < j) {
                while (i < j && (strs[j] + temp).compareTo(temp + strs[j]) >= 0) j--;
                while (i < j && (strs[i] + temp).compareTo(temp + strs[i]) <= 0) i++;
                swap(strs, i, j);
            }
            swap(strs, i, l);
            quickSort(strs, l, i - 1);
            quickSort(strs, i + 1, r);
        }
    }

    void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}


