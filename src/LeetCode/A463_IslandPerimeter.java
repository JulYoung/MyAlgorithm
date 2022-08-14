package LeetCode;

// 岛屿周长
public class A463_IslandPerimeter {


    static class Solution {
        public int islandPerimeter(int[][] grid) {
            if (grid == null)
                return 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return dfs(grid, i, j);
                    }
                }
            }
            return 0;
        }

        public int dfs(int[][] grid, int i, int j) {
            // 超出边界
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return 1; // 周长加1
            }
            // 遇到水
            if (grid[i][j] == 0) {
                return 1;
            }
            // 遇到本岛屿
            if (grid[i][j] == -1) {
                return 0;
            }

            grid[i][j] = -1;

            return dfs(grid, i - 1, j) +
                    dfs(grid, i + 1, j) +
                    dfs(grid, i, j - 1) +
                    dfs(grid, i, j + 1);

        }
    }
}

