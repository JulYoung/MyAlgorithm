package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A77_Combine {
    public static void main(String[] args) {
        A77_Combine solution = new A77_Combine();
        System.out.println(solution.combine(3, 3));

    }
    // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    // 回溯
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        backtrack(n, k, stack, 1);
        return res;
    }

    public void backtrack(int n, int k, Stack<Integer> stack, int start) {
        // 结束条件
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
        }
        // 选择列表
        for (int i = start; i <= n; i++) {
            // 选择
            stack.add(i);
            // 下一个判断
            backtrack(n, k, stack, i + 1);
            // 重置
            stack.pop();
        }
    }


}
