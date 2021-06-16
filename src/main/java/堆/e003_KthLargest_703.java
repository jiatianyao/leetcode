package 堆;

import java.util.PriorityQueue;

/**
 *
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class e003_KthLargest_703 {

    int k;
    int[] nums;
    PriorityQueue<Integer> smallHeap;

    public e003_KthLargest_703(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.smallHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length && i < k; ++i) {
            // 将 nums 的前 k 个数（如有）入堆
            this.smallHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; ++i) {
            // 将 nums 剩余的数（如有）依次和堆顶元素比较
            // 动态维护堆的 size 为 k
            if (nums[i] > this.smallHeap.peek()) {
                this.smallHeap.poll();
                this.smallHeap.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        int res = val;

        if (smallHeap.size() < k) {
            // 如果此时堆的 size 还没到 k，直接将 val 入堆
            smallHeap.add(val);
        } else {
            // 否则将 val 和堆顶元素比较来决定是否入堆
            if (val > this.smallHeap.peek()) {
                this.smallHeap.poll();
                this.smallHeap.add(val);
            }
        }

        res = smallHeap.peek();

        return res;
    }
}
