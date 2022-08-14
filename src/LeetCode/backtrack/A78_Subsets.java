package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A78_Subsets {
    public static void main(String[] args) {
        A78_Subsets solution = new A78_Subsets();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }

    // 求解数组的子集 —- 回溯
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        backtrack(nums, 0, stack);
        return res;
    }

    public void backtrack(int[] nums, int start, Stack<Integer> stack) {
        // 结束条件
        res.add(new ArrayList<>(stack));
        // 选择列表
        for (int i = start; i < nums.length; i++) {
            // 选择
            stack.push(nums[i]);
            // 下一阶段判断
            backtrack(nums, i + 1, stack);
            // 回溯
            stack.pop();
        }
    }
}
