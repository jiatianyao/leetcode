package 深搜广搜;

/**
 * 827. 最大人工岛
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * 示例 1:
 *
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 *
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 *
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * https://leetcode-cn.com/problems/making-a-large-island/
 */
public class l014_largestIsland_827 {

    //深搜,超时....
    int m,n;
    boolean flag = true;
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean all = true;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!=1) {
                    all = false;
                    int[][] copy = chageBack(grid);
                    copy[i][j] = 1;
                    int res = dfs(copy, i, j);
                    result=Math.max(res,result);
                }
            }
        }
        if(all) return m*n;
        return result;
    }

    private int[][] chageBack(int[][] grid){
        int[][] reuslt = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reuslt[i][j] = grid[i][j];
            }
        }
        return reuslt;
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

    public static void main(String[] args) {
        l014_largestIsland_827 demo = new l014_largestIsland_827();
        demo.largestIsland(new int[][]{{1,0},{0,1}});
    }
}
