package 每日一题;

public class daily_0717_maxSubArray_offer_42 {
    //dp[i]表示nums[i]结尾的连续子数组的最大和
    //dp[i-1] >0 => dp[i] = dp[i-1]+nums[i]
    //dp[i-1] <=>0 => dp[i] = nums[i]
    //初始化dp[i]=nums[i]
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len ==0)return 0;
        int dp[] = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
