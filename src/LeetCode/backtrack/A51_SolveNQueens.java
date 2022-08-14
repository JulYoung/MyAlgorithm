package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A51_SolveNQueens {
    public static void main(String[] args) {
        A51_SolveNQueens so = new A51_SolveNQueens();
        System.out.println(so.solveNQueens(4));
    }

    // 回溯：路径 - 选择列表 - 结束条件
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        // 回溯
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        // 结束条件
        if (row == board.length) {
            res.add(arrayToList(board));
        }
        // 选择列表
        for (int col = 0; col < board[0].length; col++) {
            // 排除不合法的
            if (!isValid(board, row, col)) continue;
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销
            board[row][col] = '.';
        }
    }

    // 判断是否可以在row行col列放置皇后
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查行
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 'Q')
                return false;
        }
        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public List<String> arrayToList(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(new String(chars));
        }
        return res;
    }
}
