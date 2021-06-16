package test;

public class dp1 {
    private static int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private static int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量
    private static boolean[][] mem = new boolean[5][10]; // 备忘录,默认值false

    public static void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态
        mem[i][cw] = true; // 记录(i, cw)这个状态
        System.out.println("==="+i);
        f(i + 1, cw); // 选择不装第i个物品
        System.out.println("----"+i);
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }

    public static void main(String[] args) {
        f(0,0);
        System.out.println(maxW);
    }


    /**
     * 贪心 解决最优解问题。从局部最优到整体最优
     *
     * DP类型：
     * 线性模型
     * 区间DP
     * 数位DP
     * 状态压缩DP
     * 树状DP
     *
     * 优化方法：
     * 股东数组优化  节省空间
     * 矩阵乘法优化  节省时间
     * 斜率优化      优化时间复杂度
     * 四边形不等式优化    优化时间复杂度
     * 决策单调性优化    优化时间复杂度
     * 数据结构优化    优化时间和空间
     */

    /**
     *             0  1  2  3  4  5  6  7  8  9
     * 物品2    0  1  0  1
     * 物品2    1  1  0  1     1
     * 物品4    2  1  0  1     1     1     1
     * 物品6    3  1  0  1     1     1     1
     * 物品3    4  1  0  1  1  1  1  1  1  1   1
     */
    //weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) {//把第i个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }



    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w-items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]==true) states[j+items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }


}
