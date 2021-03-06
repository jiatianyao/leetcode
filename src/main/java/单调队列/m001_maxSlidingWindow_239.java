package 单调队列;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class m001_maxSlidingWindow_239 {
    //方法1:大顶堆
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[] > pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            //值相同按照下标排序,值不同按照值排序o是{nums[i],i}
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0]- o1[0] : o2[1]- o1[1] ;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        int[] result = new int[n-k+1];
        result[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1]<= i-k){
                pq.poll();
            }
            result[i-k+1] = pq.peek()[0];
        }
        return result;
    }
}
