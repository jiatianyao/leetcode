package 排序算法;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,8,5,9};
        //从最后一个非叶节点开始构建大顶堆
        for (int i = arr.length/2-1; i >=0; i--) {
            maximumHeap(i,arr);
        }
        //从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
        for (int i = arr.length-1; i >=0; i--) {
            swap(arr,0,i);
            maximumHeap(0,arr);
        }
        System.out.println(Arrays.toString(arr));
    }
    //构建大顶堆
    public static void maximumHeap(int i,int[] arr){
        int temp = arr[i];
        for (int j = i*2+1; j < arr.length; j=j*2+1) {
            //如果右孩子大于做孩子，则指向右孩子
            if(j+1<arr.length && arr[j+1]>arr[j]){
                j++;
            }
            //如果最大的孩子大于当前节点，则将大孩子赋给当前节点，修改当前节点为其大孩子节点，再向下走。
            if(arr[j]>temp){
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
        //将temp放到最终位置
        arr[i] = temp;
    }
    //交换
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
