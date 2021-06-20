package 深搜广搜;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 473. 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 *
 * https://leetcode-cn.com/problems/matchsticks-to-square/
 */
public class l003_makesquare_473 {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length ==0 || matchsticks ==null) return false;
        int[] sums = new int[4];
        int sum = Arrays.stream(matchsticks).sum();
        int sideLen = sum / 4;
        if(sideLen * 4 != sum) return false;
        List<Integer> nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(nums,Collections.reverseOrder());

        return dfs(0,nums,sideLen,sums);
    }

    private boolean dfs(int index, List<Integer> nums, int sideLen, int[] sums) {
        if(index == nums.size()) return sums[0] ==  sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        int element = nums.get(index);
        for (int i = 0; i < sums.length; i++) {
            if(sums[i] +element <= sideLen ){
                sums[i]+=element;
                if(dfs(index+1,nums,sideLen,sums)){
                    return true;
                }
                sums[i]-=element;
            }
        }
        return false;
    }
}
