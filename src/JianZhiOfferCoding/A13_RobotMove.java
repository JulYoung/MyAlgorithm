package JianZhiOfferCoding;

// 机器人移动问题
public class A13_RobotMove {
    public static void main(String[] args) {


    }

    static class Solution {
        int m, n, k;
        boolean[][] visited;

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        public int dfs(int i, int j, int si, int sj) {
            // 判断是否越界
            if (i >= m || j >= n || k < si + sj || visited[i][j])
                return 0;
            visited[i][j] = true;

            int r = dfs(i + 1, j, sums(i + 1), sj);  // 右移
            int d = dfs(i, j + 1, si, sums(j + 1));  // 左移

            return 1 + r + d;

        }

        // 计算数字的每位数之和
        int sums(int x) {
            int s = 0;
            while (x != 0) {
                s += x % 10;
                x = x / 10;
            }
            return s;
        }
    }

}
