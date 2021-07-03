package 单调队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class m0002_Offer_59_MaxQueue {
    //主队列,正常的存取数据
    Queue<Integer> queue;
    //单调不减的双端队列,存储主队列中的最大值
    Deque<Integer> deque;

    public m0002_Offer_59_MaxQueue() {
        queue = new ArrayDeque<>();
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst())){
            deque.pollFirst();
        }
        return queue.poll();
    }
}
