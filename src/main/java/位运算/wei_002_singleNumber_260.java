package 位运算;

/**
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * https://leetcode-cn.com/problems/single-number-iii/
 */
public class wei_002_singleNumber_260 {
    public static int[] singleNumber(int[] nums) {
        //将数字分成AB两组,分别求其差的数
        //需要满足条件,
        //1.相同的数字分成相同的组,
        //2.两个特别的数字分到不同组
        int a=0,b=0;
        int x=0;
        //异或结果x为a^b结果,x的每一位如果为1则表明ab当前位置不同,为0表明当前位置结果相同
        for (int num : nums) {
            x^=num;
        }
        //找到第i位不是0的数字Xi,这里的代码选取的是「不为 0 的最低位」
        int m=1;
        while((m&x) ==0){
            m = m<<1;
        }
        //随便取一个,异或为0分一组,不为0分一组
        for (int num : nums) {
            if((num & m )==0) a^=num;
            else b^=num;
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        singleNumber((new int[]{1,2,1,3,2,5}));
    }
}
