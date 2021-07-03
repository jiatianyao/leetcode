package 单调队列;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 *
 * https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
 */
public class m0003_shortestSubarray_862 {
    public int shortestSubarray(int[] nums, int k) {
        long[] arr = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            arr[i+1] = arr[i] + nums[i];
            if(nums[i] == k )return 1;
        }
        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while(!deque.isEmpty() && arr[i] <= arr[deque.getLast()]){
                deque.removeLast();
            }
            while(!deque.isEmpty() && arr[i] - arr[deque.peekFirst()] >= k){
                result = Math.min(result,i-deque.pollFirst());
            }
            deque.add(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
