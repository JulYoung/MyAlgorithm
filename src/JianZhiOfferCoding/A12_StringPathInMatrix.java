package JianZhiOfferCoding;

// 数组中的路径问题
// dfs + 剪枝。回溯法，
public class A12_StringPathInMatrix {
    public static void main(String[] args) {

    }

    static class Solution {

        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0))
                        return true;
                }
            }

            return false;
        }


        public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != words[k]) {
                return false;
            }

            if (k == words.length - 1) {  // 每一次都匹配上了
                return true;
            }

            board[i][j] = '\0'; // 标记该位置，表示已被访问过
            boolean res = dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i + 1, j, k + 1) ||
                    dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);

            board[i][j] = words[k];  // 还原至初始值
            return res;
        }

    }

}
