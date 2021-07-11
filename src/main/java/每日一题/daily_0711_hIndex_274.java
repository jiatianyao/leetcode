package 每日一题;

import java.util.Arrays;

/**
 *
 */
public class daily_0711_hIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        //如果当前 \text{H}H 指数为 hh 并且在遍历过程中找到当前值
        // citations}[i] > h，则说明我们找到了一篇被引用了至少 h+1 次的论文，
        // 所以将现有的 h 值加 1
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
