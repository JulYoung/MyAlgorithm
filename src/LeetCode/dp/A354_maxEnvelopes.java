package LeetCode.dp;

import java.util.Arrays;

public class A354_maxEnvelopes {
    public static void main(String[] args) {
        A354_maxEnvelopes solution = new A354_maxEnvelopes();
        int i = solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        System.out.println(i);
    }

    // 求最多能嵌套的信封数。
    // 对信封宽度进行升序排序，然后对长度求最长上升子序列
    // 转化为排序 + DP
    public int maxEnvelopes(int[][] envelopes) {
        // 排序
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else
                return o1[0] - o2[0];
        });

        System.out.println(Arrays.deepToString(envelopes));

        // 定义dp
        int[] dp = new int[envelopes.length];

        // base case
        Arrays.fill(dp, 1);

        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }

        return res;
    }

}
