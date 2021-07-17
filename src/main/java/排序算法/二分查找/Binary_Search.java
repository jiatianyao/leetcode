package 排序算法.二分查找;

public class Binary_Search {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,7,9,11,13,15,16};
        int i = binary_search(arr, arr.length, 15);
        System.out.println(i);
        //01模型找到第一个target的索引
        int[] arr2 = new int[]{0,0,0,0,0,1,1,1,1};
        int j =  binary_search01(arr2,arr2.length,1);
        System.out.println(j);
        //01模型找到最后一个target的索引
        int[] arr3 = new int[]{1,1,1,1,1,0,0,0,0};
        int k =  binary_search10(arr3,arr3.length,1);
        System.out.println(k);
    }


    private static int binary_search10(int[] arr, int length, int target) {
        int start = 0,end=length -1,mid;
        while(start<= end){
            mid = (start+end +1) >> 1;
            if(arr[mid] == 0 ){
                end = mid-1;
            }else{
                start = mid;
            }
            if(start == end){
                return arr[start] == target ? start : -1;
            }
        }
        return start;
    }

    private static int binary_search01(int[] arr, int length, int target) {
        int start = 0,end=length -1,mid;
        while(start< end){
            mid = start +((end - start) >> 1);
            if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }


    public static int binary_search(int[] arr,int length,int target){
        int start = 0,end=length -1,mid;
        while(start<= end){
            mid = start +((end - start) >> 1);
            if(target == arr[mid]) return mid;
            else if(target > arr[mid]){
                start = mid+1;
            }else if(target < arr[mid]){
                end = mid-1;
            }
        }
        return -1;

    }
}
