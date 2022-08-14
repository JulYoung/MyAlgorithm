package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class A491_FindSubsequences {
    public static void main(String[] args) {
        A491_FindSubsequences solution = new A491_FindSubsequences();
        System.out.println(solution.findSubsequences(new int[]{4, 6, 7, 7}));

    }
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    public void backtrack(int[] nums, int cur) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        if (cur == nums.length) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        // 选择列表
        for (int i = cur; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.peek()) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            // 选择
            path.push(nums[i]);
            set.add(nums[i]);
            // dfs
            backtrack(nums, i + 1);
            // 回溯
            path.pop();
        }
    }
}
