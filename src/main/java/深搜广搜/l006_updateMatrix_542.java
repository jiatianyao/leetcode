package 深搜广搜;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * 示例 2：
 *
 * 输入：
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *  https://leetcode-cn.com/problems/01-matrix/
 */
public class l006_updateMatrix_542 {

    class Data{
        int i = 0;
        int j = 0;
        int k = 0;

        public Data(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<Data> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        //把所有0号节点添加进搜索队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] !=0) continue;
                result[i][j] = 0;
                queue.offer(new Data(i,j,0));
            }
        }

        while(!queue.isEmpty()){
            Data cur = queue.peek();
            for (int k = 0; k < 4; k++) {
                int x = cur.i + dirs[k][0];
                int y = cur.j + dirs[k][1];
                if(x<0 || x >= m) continue;
                if(y<0 || y >= n) continue;
                if(result[x][y] != -1) continue;
                result[x][y] =cur.k +1;
                queue.offer(new Data(x,y,cur.k+1));
            }
            queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        l006_updateMatrix_542 demo = new l006_updateMatrix_542();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        demo.updateMatrix(mat);
    }

}
