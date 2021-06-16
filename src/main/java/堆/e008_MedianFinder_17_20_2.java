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
public class e008_MedianFinder_17_20_2 {
    // left为大顶堆，存小数  1
    // right为小顶堆，存大数  2，3
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public e008_MedianFinder_17_20_2() {
        left = new PriorityQueue<>((o1, o2) -> o2-o1);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        right.offer(num);
        left.offer(right.poll());
        while (left.size() > right.size()){
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.isEmpty()) {
            return 0;
        }
        if (left.size() == right.size()) {
            return (right.peek() + left.peek()) / 2.0;
        }
        return right.peek();
    }
    //0 add(1)
    //1.right =1 right =
    //2.left=  right = 1
    //3.add(2)
    //4.left = right =1,2
    //5.left =1 right =2
    //6.add(3)
    //7.left = 1 right =2,3
    //8.left = 1,2 right = 3
    //9.left.size() > right.size() lef = 1,right =2,3
    //10 2

}
