package 深搜广搜;

/**
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 示例 1：
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 * 输入：grid = [[1,0]]
 * 输出：4
 *
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class l012_islandPerimeter_463 {
    int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1) {
                    int res = dfs(grid, i, j);
                    result=Math.max(res,result);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        int res = 1;
        grid[i][j]=2;
        res+=dfs(grid, i + 1, j);
        res+=dfs(grid, i - 1, j);
        res+=dfs(grid, i, j + 1);
        res+=dfs(grid, i, j - 1);
        return res;
    }
}
