package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A46_Permute {
    public static void main(String[] args) {
        A46_Permute solution = new A46_Permute();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    /** 框架
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */
    boolean[] used;  // 记录选择过的。
    Stack<Integer> stack;  // 记录路径
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        stack = new Stack<>();
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int depth) {
        // 结束条件
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
        }
        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 访问i位
            used[i] = true;
            stack.add(nums[i]);
            // 下一阶段判断
            dfs(nums, depth + 1);
            // 回溯
            used[i] = false;
            stack.pop();
        }
    }
}
