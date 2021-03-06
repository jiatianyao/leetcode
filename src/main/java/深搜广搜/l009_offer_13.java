package 深搜广搜;

import java.util.LinkedList;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
 * （不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class l009_offer_13 {
    int[] dirX = {0,1};
    int[] dirY = {1,0};
    public int movingCount(int m, int n, int k) {
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0,0});
        int result = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int j = 0; j < 2; j++) {
                    int xNew = x + dirX[j];
                    int yNew = y + dirY[j];
                    if(xNew >=0 && xNew < m && yNew >=0 && yNew < n && get(xNew) + get(yNew) <=k
                            && !visited[xNew][yNew]){
                        result++;
                        visited[xNew][yNew] = true;
                        queue.add(new int[]{xNew,yNew});
                    }
                }
            }
        }
        return result;
    }

    private int get(int x) {
        int result = 0;
        while(x!=0){
            result += x % 10;
            x /= 10;
        }
        return result;
    }
}
