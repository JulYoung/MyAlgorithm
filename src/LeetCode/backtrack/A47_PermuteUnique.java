package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class A47_PermuteUnique {
    public static void main(String[] args) {
        A47_PermuteUnique solution = new A47_PermuteUnique();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
    boolean[] used;
    Stack<Integer> stack;
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        stack = new Stack<>();
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || set.contains(nums[i])) continue;
            // 访问i位
            set.add(nums[i]);
            used[i] = true;
            stack.add(nums[i]);
            // 递归
            dfs(nums, depth + 1);
            // 回溯
            used[i] = false;
            stack.pop();
        }
    }
}
