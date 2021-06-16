package 堆;

import java.util.PriorityQueue;

/**
 * 面试题 17.20. 连续中值
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class e008_MedianFinder_17_20 {
    // 始终保证left的队列大小-right的队列大小<=1
    // left为大顶堆，顶部为其中一个中位数
    // right为小顶堆，顶部可能为其中一个中位数
    PriorityQueue<int[]> left;
    PriorityQueue<int[]> right;

    public e008_MedianFinder_17_20() {
        left = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        right = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
    }

    public void addNum(int num) {
        if (left.isEmpty()) {
            left.offer(new int[]{num});
            return;
        }
        if (num <= left.peek()[0]) {
            left.offer(new int[]{num});
            while (left.size() - right.size() > 1) {
                right.offer(left.poll());
            }
        } else {
            right.offer(new int[]{num});
            while (right.size() - left.size() > 0) {
                left.offer(right.poll());
            }
        }
    }

    public double findMedian() {
        if (left.isEmpty()) {
            return 0;
        }
        if (left.size() == right.size()) {
            return (left.peek()[0] + right.peek()[0]) / 2.0;
        }
        return left.peek()[0];
    }
}
