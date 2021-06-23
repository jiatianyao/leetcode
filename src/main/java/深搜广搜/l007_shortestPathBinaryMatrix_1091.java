package 深搜广搜;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 *
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class l007_shortestPathBinaryMatrix_1091 {
    int[] dirX = {0,0,-1,-1,-1,1,1,1};
    int[] dirY = {-1,1,0,1,-1,0,-1,1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;//特殊情况特殊考虑，出口和入口被堵死
        if(m == 1 && grid[0][0] ==0) return 1;//只有一个0的情况
        Queue<int[]> queue = new LinkedList();
        boolean[][] visit = new boolean[m][n];//识别数组
        visit[0][0] = true;
        queue.add(new int[]{0,0});
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int j = 0; j < 8; j++) {
                    int x1 = x+dirX[j];
                    int y1 = y+dirY[j];
                    if(x1>=0 && x1<m && y1>=0 && y1<n && grid[x1][y1]==0 && !visit[x1][y1]) {//数组不越界，值为1，//没有被访问过才能入队
                        queue.add(new int[]{x1,y1});//入队
                        visit[x1][y1] = true;
                    }

                }
                if(x==m-1 && y==n-1) return step;//终止条件
            }
            step++;

        }
        return -1;//队列为空即为不能到达终点，返回-1
    }
}
