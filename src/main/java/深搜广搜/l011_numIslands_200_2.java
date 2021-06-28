package 深搜广搜;

import java.util.LinkedList;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 */

public class l011_numIslands_200_2 {
    int m,n;
    //广度优先遍历
    public int numIslands(char[][] grid) {
        m = grid.length;
        n=grid[0].length;
        int step = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    step++;
                    queue.add(new int[]{i,j});
                    grid[i][j] = '0';
                    bfs(grid,queue);
                }
            }
        }
        return step;
    }

    private void bfs(char[][] grid, LinkedList<int[]> queue) {
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if(x+1 < m && grid[x+1][y] =='1' ){
                grid[x+1][y] = '0';
                queue.add(new int[]{x+1,y});
            }
            if(x-1>=0 && grid[x-1][y] =='1' ){
                grid[x-1][y] = '0';
                queue.add(new int[]{x-1,y});
            }
            if(y+1 <n && grid[x][y+1] =='1'  ){
                grid[x][y+1] = '0';
                queue.add(new int[]{x,y+1});
            }
            if(y-1>=0 && grid[x][y-1] =='1'){
                grid[x][y-1] = '0';
                queue.add(new int[]{x,y-1});
            }
        }
    }
}
