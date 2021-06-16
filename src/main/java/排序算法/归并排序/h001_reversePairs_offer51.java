package 排序算法.归并排序;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class h001_reversePairs_offer51 {
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums,temp,0,nums.length-1);
    }

    public int mergeSort(int[] nums, int[] temp,int left,int right){
        if(left >=right) return 0;
        int ans = 0,mid = (left+right) >>1;
        int temIndex=left,l=left,r=mid+1;

        ans+= mergeSort(nums,temp,left,mid);
        ans+= mergeSort(nums,temp,mid+1,right);
        while(l<= mid || r <= right){
            if(r> right || (l<=mid && nums[l]<=nums[r])){
                temp[temIndex++] = nums[l++];
            }else{
                temp[temIndex++] = nums[r++];
                ans+=(mid-l+1);
            }
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        h001_reversePairs_offer51 demo = new h001_reversePairs_offer51();
        demo.reversePairs(new int[]{7,5,6,4});
    }

}
