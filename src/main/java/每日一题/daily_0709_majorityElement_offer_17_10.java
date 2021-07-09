package 每日一题;

import java.util.Arrays;

public class daily_0709_majorityElement_offer_17_10 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if(length<=1) return nums[0];
        Arrays.sort(nums);
        int left = 0,right =0,cur=0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if(cur != num){
                cur = num;
                left = i;
                right = i;
            }else{
                ++right;
                if(right-left+1 >= (length+1)/2 ){
                    return num;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        daily_0709_majorityElement_offer_17_10 demo = new daily_0709_majorityElement_offer_17_10();
        demo.majorityElement(new int[]{1});
    }

}
