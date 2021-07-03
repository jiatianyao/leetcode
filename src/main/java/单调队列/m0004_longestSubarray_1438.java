package 单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class m0004_longestSubarray_1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        //单调递减队列
        Deque<Integer> queueMax = new ArrayDeque<>();
        //单调递增队列
        Deque<Integer> queueMin = new ArrayDeque<>();
        int left = 0,right=0;
        int result = 0;
        while (right < n) {
            while (!queueMax.isEmpty() && queueMax.peekLast() < nums[right]) {
                queueMax.pollLast();
            }
            while (!queueMin.isEmpty() && queueMin.peekLast() > nums[right]) {
                queueMin.pollLast();
            }
            queueMax.offerLast(nums[right]);
            queueMin.offerLast(nums[right]);
            //不满足条件弹出左边界值
            while (!queueMax.isEmpty() && !queueMin.isEmpty() && queueMax.peekFirst() - queueMin.peekFirst() > limit) {
                if (nums[left] == queueMin.peekFirst()) {
                    queueMin.pollFirst();
                }
                if (nums[left] == queueMax.peekFirst()) {
                    queueMax.pollFirst();
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
