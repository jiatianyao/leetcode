package 排序算法;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import exam.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
//        int[] arr = new int[]{79,56,90,4,32,27,16,88,35,32};
        int[] arr = new int[]{84,83,88,87,61,50,70,60,80,99};
        System.out.println("排序前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        radixSort(arr);
        System.out.println("\n排序后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

    // 冒泡排序：相邻元素进行比较然后交换，类似冒泡。在每一轮冒泡中会有许多次交换，最后产生一个最值（在数组最后）
    private static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {   //遍历n-1次
            for (int j = 0; j < length -i; j++) { //遍历n-j次
                int x = arr[j];
                int y = arr[j+1];
                if(x>y){
                    int temp = x;
                    arr[j] = y;
                    arr[j+1] = temp;
                }
            }
        }
    }

    //选择排序：不断寻找最小元素的索引。每完成一轮寻找，就会找到一个最小值元素索引，然后手动交换到头部
    private static void selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i+1; j < length; j++) {
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            if(index !=i){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    //插入排序：前面的元素都是有序的，对后面元素寻找合适位置插入到前面
    //1. 保存当前元素。2。定位合适位置，每个元素后移一位。3。插入
    private static void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int index = i;
            int cur = arr[i];
            while(index>0 && cur<arr[index-1]){
                arr[index] = arr[index-1];
                index--;
            }
            arr[index] = cur;
        }
    }


    //希尔排序 ：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
    private static void shellSort(int[] arr) {
        int length = arr.length;
        int gap = length;
        do {
            gap = gap / 3 + 1;
            for (int i = 0; i < gap; i++) {
                for (int j = gap+i; j < length; j+=gap) {
                    int index = j;
                    int cur = arr[j];
                    while(index>0 && index-gap >=0 && cur<arr[index-gap]){
                        arr[index] = arr[index-gap];
                        index = index-gap;
                    }
                    arr[index] = cur;

                }

            }
        }while(gap > 1);

    }

    //快速排序:选一个数作为基数,大于这个基数的放到右边，小于这个基数的放到左边,等于这个基数的数可以放到左边或右边
    private static void quickSort(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        recursion2(arr,start,end);
    }

    private static void recursion(int[] arr, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int temp = arr[start];
        while(left<right){
            while(left<right && arr[right] >=temp ) right--;
            if(left<right){
                arr[left++] = arr[right];
            }
            while(left<right && arr[left] <temp ) left++;
            if(left<right){
                arr[right--] = arr[left];
            }
        }
        arr[left] = temp;
        //初始化:          84,83,88,87,61,50,    70,   60,   80,99
        //第一次选84为temp 80,83,60,70,61,50,    84,   87,   88,99
        //              start,83,60,70,61,left-1,temp,left+1,88,end
        //拆成start到left-1和left+1到end
        recursion(arr,start,left-1);
        recursion(arr,left+1,end);
    }

    //一次遍历优化
    private static void recursion2(int[] arr, int start, int end) {
        while(start<end) {
            int left = start;
            int right = end;
            int temp = arr[start];
            while (left < right) {
                while (left < right && arr[right] >= temp) right--;
                if (left < right) {
                    arr[left++] = arr[right];
                }
                while (left < right && arr[left] < temp) left++;
                if (left < right) {
                    arr[right--] = arr[left];
                }
            }
            arr[left] = temp;
            recursion(arr,left+1,end);
            end=left-1;
        }
    }
    /**
     * 归并排序 1.分解（大数组不断分解）2.合并（将小数组排序合并）
     * 1.临时数组：创建一个临时数组，存放两个小数组合并后的结果
     * 2.比较放入：将小的元素放入，并将当前小元素数组的索引后移，直到一个数组全部放入完毕
     * 3.剩余放入：由于结束条件是一个数组放完就行，所以有一个数组还没放入，直接加到临时数组后即可
     * 4.数组还原：将临时数组的元素，按原位置放回待排序数组
     */
    private static void mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr,int left,int right) {
        if(left>=right) return;
        int mid = (left+right) >>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        int[] temp = new int[right-left+1];
        int k=0,l =left,r=mid+1;
        while(l<= mid || r <= right){
            if(r> right || (l<=mid && arr[l]<=arr[r])){
                temp[k++] = arr[l++]; //相当于arr[k] = arr[l]; l++; k++;
            }else{
                temp[k++] = arr[r++]; //相当于arr[k] = arr[r]; r++; k++;
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i-left];
        }
    }

    /**
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]  每个结点的值都大于或等于其左右孩子结点的值
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]  每个结点的值都小于或等于其左右孩子结点的值
     * 1.构造初始堆。将给定无序序列构造成一个大顶堆（一般升序采用大顶堆，降序采用小顶堆)。
     * 2.将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，
     * 再将堆顶元素与末尾元素交换，得到第二大元素。如此反复进行交换、重建、交换。
     *
     */
    private static void heapSort(int[] arr) {
        int length = arr.length;

        // 1.构建最大堆：从最后一个不是叶子节点的节点开始下沉
        // i=(length-1)/2，表示获取最后一个叶子节点的父亲，即最后一个不是叶子节点的节点
        for (int i = (length - 1) / 2; i >= 0; i--) {
            heapSort(arr,length, i);
        }
        for (int i = length - 1; i > 0; i--) {
            // 2.取出堆顶：通过交换堆顶（arr[0]）到堆尾（arr[i]），实现出堆顶
            swap(arr, 0, i);
            // 3.新堆再平衡：上一步已经将堆尾换到了堆首，所以直接再下沉就行
            // 注：可以看到这里新堆的长度变成了i（比之前少了1）
            heapSort(arr, i, 0);
        }

    }

    private static void heapSort(int[] arr, int length, int idx) {
        // 下沉到叶节点，就没有儿子了，就不用下沉了
        // 这里用的leftChild（2*idx），因为如果左儿子都超过length了，右儿子也一定超过了
        while (2 * idx < length) {

            // 判断左儿子和右儿子哪个大
            int j = 2 * idx;
            if (j + 1 < length && arr[j+1] > arr[j])
                j++; // 如果右儿子大，就j++

            // 判断父亲是否比儿子大
            if (arr[idx] >= arr[j])
                break;

            // 父亲小于儿子，那么就交换父子
            swap(arr, idx, j);
            // 更新父亲idx，继续去下一棵子树判断下沉
            idx = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //计数排序
    private static void countSort(int[] arr) {
        if (arr.length < 2) return;
        // 1.计算桶个数，数组元素最大值 + 1
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) maxValue = arr[i];
        }
        // 2.创建桶
        int[] buckets = new int[maxValue + 1];
        // 3.将原数组元素放入桶们
        // 3.1 匹配对应桶号，桶元素++
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i]]++;
        }
        // 3.2 将桶元素依次累加 --> 桶号=数组元素，桶元素=小于等于当前桶号的元素个数
        // --> 有序数组下标 = 桶元素 - 1，-1因为记录的是个数
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }
        // 4.通过临时数组完成排序
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 4.1 计算数组下标：有序数组下标 = 桶元素 - 1；
            int idx = buckets[arr[i]] - 1;
            // 4.2 放入临时数组，tmp[桶元素 - 1] = 桶号 = arr[i]
            tmp[idx] = arr[i];
            // 4.3 对应桶元素--
            buckets[arr[i]]--;
        }
        // 5. 拷贝临时数组到待排序数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }

    //基数排序
    private static void radixSort(int[] arr) {
        // 寻找最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        // 寻找arr中最大数字的位数
        int keyNum = 0;
        while (max > 0) {
            max /= 10;
            keyNum++;
        }
        // 初始化10个小桶，代表位数0-9
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // 开始基数排序，位数作为外层循环
        for (int i = 0 ; i < keyNum; i++) {
            // 1.遍历数组，按i+1位放入相应桶（因为i从0开始）
            for (int j = 0; j < arr.length; j++) {
                // 例：1234的第3位 = 1234 / 100 % 10 = 12 % 10 = 2
                int key = arr[j] / (int)Math.pow(10, i + 1) % 10;
                buckets.get(key).add(arr[j]);
            }

            // 2.将按i+1位排序的结果放回原数组，准备进入下一轮排序
            // 注：这里counter是为了记录原数组下标
            int counter = 0;
            for (int j = 0; j < 10; j++) {
                List<Integer> bucket = buckets.get(j);
                while (bucket.size() > 0) {
                    arr[counter++] = bucket.remove(0);
                }
            }
        }
    }



}
