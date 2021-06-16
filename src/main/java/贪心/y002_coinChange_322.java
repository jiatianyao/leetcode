package 贪心;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * 新的用例导致数据超时，此题已不能归类为贪心算法里的题了。贪心是解不出来答案的，如果有人能解出联系我15501086574
 * 答案参考z002_coinChange_322
 */
public class y002_coinChange_322 {
    public int minTime = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }

    public void coinChange(int[] coins, int amount,int index,int times){
        if(index <0 ) return;
        if(amount ==0){
            if(minTime > times){
                minTime = times;
            }
            return;
        }
        for(int j = amount/coins[index];j>=0 && j + times < minTime;j--){
            coinChange(coins, amount-j*coins[index], index - 1, times+j);
        }
    }

    public static void main(String[] args) {
        y002_coinChange_322 demo = new y002_coinChange_322();
        demo.coinChange(new int[]{1,2,5},11);
        System.out.println(demo.minTime);

    }
}
