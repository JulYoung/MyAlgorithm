package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class A22_GenerateParenthesis {
    public static void main(String[] args) {
        A22_GenerateParenthesis solution = new A22_GenerateParenthesis();
        System.out.println(solution.generateParenthesis(3));
    }
    // 回溯问题。dfs
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder path = new StringBuilder();
        backtrack(n, n, n, path);
        return res;
    }
    public void backtrack(int n, int left, int right, StringBuilder path) {
        // 剪枝
        if (left < 0 || right < 0 || left > right) {  // 左括号剩余的数量不能大于右括号
            return;
        }
        // 结束条件
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        // 选择列表
        // 1 选择加入左括号
        path.append('(');
        backtrack(n, left - 1, right, path);
        path.deleteCharAt(path.length() - 1);

        // 2 选择加入右括号
        path.append(')');
        backtrack(n, left, right - 1, path);
        path.deleteCharAt(path.length() - 1);
    }
}
