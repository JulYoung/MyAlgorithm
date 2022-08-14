package LeetCode;

// 岛屿的最大面积
public class A695_MaxAeraOfIsland {



    // dfs
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int area = dfs(grid, i, j);
                        res = Math.max(res, area);
                    }
                }
            }

            return res;
        }

        public int dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
                return 0;
            }

            grid[i][j] = 0;

            // 此时面积等于1
            int num = 1;

            num += dfs(grid, i - 1, j); // 上
            num += dfs(grid, i + 1, j); // 下
            num += dfs(grid, i, j - 1); // 左
            num += dfs(grid, i, j + 1); // 右

            return num;
        }
    }
}

