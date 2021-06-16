package 堆;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class e010_nthUglyNumber_264 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        heap.add(1L);

        HashSet<Long> seen = new HashSet();
        seen.add(1L);

        int[] factors = new int[]{2, 3, 5};

        long currUgly = 1, newUgly;

        for (int i = 0; i < n; ++i) {
            currUgly = heap.poll();
            for(int f: factors) {
                newUgly = currUgly * f;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}
