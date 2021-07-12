package 排序算法.快速排序;

import java.util.Arrays;

public class g_quickSort2 {

    /**
     * 快速排序算法
     * @param nums 要排序的数组
     * @param left 数组最左端记录的下标
     * @param right 数组最右端记录的下标
     */
    public static void quickSort(int[] nums, int left, int right){
        if (left > right){
            // 不合理
            return;
        }
        // 定义两个变量(哨兵)来接管left和right，left和right后面会用得到
        int l = left;
        int r = right;
        // 定义一个参考值，这里以最右端的作为参考值
        int reference = nums[r];
        while (l != r){  // 只要两个哨兵没有碰头就继续找
            // 参考值取的是右边的，则让左边的先找比参考值小的数
            while(nums[l] <= reference && l < r){
                // 没找到，继续往前找
                l++;
            }
            // 左边已经找到了，让右边的去找比参考值大的数
            while(nums[r] >= reference && l < r){
                // 没找到，继续往后找
                r--;
            }
            // 两个都找到了，就互相交换值之后，再继续找，直到碰面
            swap(nums,l,r);
        }
        // 循环结束，表明l和r已经碰面(找到同一个数字上去了)
        // 这时就要将碰面的这个值与参考值交换
        swap(nums,r,right);
        // l和r碰面的地方将原本数组分割成两个，再对这两个进行上诉操作，直到无法操作就完成排序了
        // 也就是说碰面的地方已经放到了属于他应该在的位置，不用管了
        quickSort(nums,left,l - 1);
        quickSort(nums,r + 1,right);
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{11, 21, 28, 12, 5, 8, 30};
        quickSort(ints, 0, 6);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
