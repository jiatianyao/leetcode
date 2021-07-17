package 排序算法.二分查找;

public class j002_searchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0,end=nums.length -1,mid;
        while(end -start > 3){
            mid = start + ((end- start) >>1);
            if(nums[mid]>= target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        for (int i = start; i <= end; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        j002_searchInsert_35 demo = new j002_searchInsert_35();
        int res = demo.searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(res);
    }
}
