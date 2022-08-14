package JianZhiOfferCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 和为s的连续正数序列
public class A57_2_findContinuousSequence {
    public static void main(String[] args) {
        A57_2_findContinuousSequence so = new A57_2_findContinuousSequence();
        int[][] res = so.findContinuousSequence(9);
        System.out.println(Arrays.deepToString(res));
    }
    // 滑动窗口
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 0;
        List<int[]> list = new ArrayList<>();

        while (j <= target / 2 + 1) {
            int cur = j;
            j++;
            sum += cur;

            while (sum > target) {
                sum -= i;
                i++;
            }
            if (sum == target) {
                int[] ans = new int[j - i];
                for (int k = 0; k < j - i; k++) {
                    ans[k] = k + i;
                }
                list.add(ans);
            }
        }
        return list.toArray(new int[0][0]);
    }

    public int[][] findContinuousSequence2(int target) {
        int i = 1, j = 2, s = 3;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < j && j <= target / 2 + 1) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

}

