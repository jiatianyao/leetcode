package 每日一题;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 */
public class daliy_0704_findErrorNums_645 {
    //这可能是最low的解法了
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(set.contains(num)){
                result[0] = num;
            }
            if (num != i + 1 && result[1] == 0 && i+1<nums.length && nums[i+1] !=i+1) {
                result[1] = i + 1;
            }
            set.add(num);
        }
        if(result[1] == 0){
            result[1] = nums[nums.length-1]+1;
        }
        return result;
    }

    public static void main(String[] args) {
        daliy_0704_findErrorNums_645 demo = new daliy_0704_findErrorNums_645();
        demo.findErrorNums(new int[]{1,1});
    }
}
