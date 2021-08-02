package 每日一题;

import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * 示例 1：
 *
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 *
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class daily_0802_kWeakestRows_1337_2 {
    //二分+大顶堆
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
            if(o1[1] != o2[1]){
                //升序
                return o1[1] - o2[1];
            }else{
                //升序
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < m; i++) {
            int[] matM = mat[i];
            int j = binarySerach(matM,0,n-1) ;
            pq.offer(new int[]{i,j});
        }


        for (int x = 0; x < k; x++) {
            res[x] = pq.poll()[0];
        }
        return res;
    }

    //10模型找到最后一个1,返回的为索引数+1 = 1的个数
    private int binarySerach(int[] arr,int left,int right) {
        while(left<right){
            int mid = (right + left +1 ) >> 1;
            if( arr[mid] ==1 ){
                left = mid;
            }else{
                right = mid -1;
            }
            if(right == left){
                return arr[left] ==1 ? left+1 : 0;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        daily_0802_kWeakestRows_1337_2 demo = new daily_0802_kWeakestRows_1337_2();
//        int[] arr = new int[]{1, 1, 1, 0, 0, 0, 0};
//        int i = demo.binarySerach(arr, 0, arr.length-1);
//        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[][] mat = new int[][]{{1,0},{0,0},{1,0}};
        int[] res = demo.kWeakestRows(mat, 3);
        System.out.println(res);
    }
}
