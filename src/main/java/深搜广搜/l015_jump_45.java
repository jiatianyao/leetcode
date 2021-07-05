package 深搜广搜;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * 输入: [2,3,0,1,4]
 * 输出: 2
 */
public class l015_jump_45 {
    public int jump(int[] nums) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(0);
        int len = nums.length;
        int result = 0;
        boolean[] visited = new boolean[len];
        visited[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -->0){
                int idx = queue.poll();
                if(idx == len-1){
                    return result;
                }
                for (int i = idx+1; i <= idx + nums[idx] && i< len; i++) {
                    if(!visited[i]){
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
            result++;
        }
        return result;
    }
}
