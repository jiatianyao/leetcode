package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1743. 从相邻元素对还原数组
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 *
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 *
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 *
 * https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
 */
public class daily_0725_restoreArray_1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        //利用hash表找到边界元素,即相邻元素只有一个的
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int len = adjacentPairs.length+1;
        int[] res = new int[len];
        //左右边任取其一
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                res[0] = e;
                break;
            }
        }
        res[1] = map.get(res[0]).get(0);
        //根据当前元素和上一个元素确定下一个元素(配对上一个元素和下一个元素都在adj内)
        for (int i = 2; i < len; i++) {
            List<Integer> adj = map.get(res[i - 1]);
            //adj = 1,3  res[i-2]=1 则res[i] =3
            res[i] = res[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        daily_0725_restoreArray_1743 demo = new daily_0725_restoreArray_1743();
        demo.restoreArray(new int[][]{{2,1},{3,5},{3,2}});
    }

}
