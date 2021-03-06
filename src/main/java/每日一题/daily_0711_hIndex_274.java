package 每日一题;

import java.util.Arrays;

/**
 *
 * 274. H 指数
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的
 * （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 * 示例：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 *
 * https://leetcode-cn.com/problems/h-index/
 */
public class daily_0711_hIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        //如果当前 H 指数为 h 并且在遍历过程中找到当前值
        // citations[i] > h，则说明我们找到了一篇被引用了至少 h+1 次的论文，
        // 所以将现有的 h 值加 1
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }


    public static void main(String[] args) {
        daily_0711_hIndex_274  demo = new daily_0711_hIndex_274();
        demo.hIndex(new int[]{0,1,3,5,6});
    }
}
