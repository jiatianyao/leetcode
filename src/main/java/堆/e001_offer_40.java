package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.lang.Integer;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class e001_offer_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;

    }

    /**
     * 小顶堆解法
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> smallHeap = new PriorityQueue<Integer>();
        for (int i : arr) {
            smallHeap.offer(i);
        }
        int[] res = new int[smallHeap.size()];
        for (int i = 0; i < k; i++) {
            int result = res[i];
            res[i] = result;
        }
        return res;
    }

    /**
     * 大顶堆解法
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> largeHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            largeHeap.offer(i);
            if(largeHeap.size()>k){//队列只保留k个，大于k个返回堆顶元素（最大的）
                largeHeap.poll();
            }
        }
//        return largeHeap.stream().mapToInt((Integer i) -> i.intValue()).toArray();
//        int[] ts = largeHeap.toArray(new int[k]);
        return largeHeap.stream().mapToInt(i->i).toArray();
    }

    /**
     * 大顶堆优化解法
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers4(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> largeHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            largeHeap.offer(arr[i]);

        }
        for (int i = k; i < arr.length; i++) {
           if(arr[i]<largeHeap.peek()){
               largeHeap.poll();
               largeHeap.offer(arr[i]);
           }
        }
        return largeHeap.stream().mapToInt(i->i).toArray();
    }



}
