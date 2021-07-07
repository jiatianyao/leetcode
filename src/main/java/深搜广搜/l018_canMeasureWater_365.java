package 深搜广搜;



import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class l018_canMeasureWater_365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int x = jug1Capacity,y = jug2Capacity,z=targetCapacity;
        if(x ==z || y ==z || z ==0) return true;
        if(x+y < z || x ==y && x+y !=z) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(temp + x <= x+y && set.add(temp+x)){
                queue.offer((temp+x));
            }
            if(temp + y <= x+y && set.add(temp+y)){
                queue.offer((temp+y));
            }
            if(temp - x >= 0  && set.add(temp-x)){
                queue.offer((temp-x));
            }
            if(temp - y >= 0  && set.add(temp-y)){
                queue.offer((temp-y));
            }
            if(set.contains(z)) return true;
        }
        return false;
    }



}
