package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * HJ28 素数伴侣
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
 * 现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案
 * 多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13
 * 编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 * 输出:
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 输入描述:
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 * 注意：数据可能有多组
 * 输出描述:
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 示例1
 * 输入
 * 4
 * 2 5 6 13
 * 2
 * 3 6
 * 输出
 * 2
 * 0
 */
public class HJ28_hard {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int n = Integer.parseInt(str1);
            int[] tempArray = new int[n];
            String str = reader.readLine();
            String[] s = str.split(" ");
            for (int i = 0; i < n; i++) {
                tempArray[i] = Integer.parseInt(s[i]);
            }
            List<Integer> evens = new ArrayList<Integer>();//偶数集合
            List<Integer> odds = new ArrayList<Integer>();//奇数集合
            for(int i = 0; i < n; i++) {
                if((tempArray[i] & 1) != 1) {
                    evens.add(tempArray[i]);
                }else {
                    odds.add(tempArray[i]);
                }
            }
            //下面开始才是重头戏
            //用于标记哪个奇数匹配了偶数,直接记录奇数的值，而不是奇数在奇数数组中的下标
            int[] evensMatch =new int[evens.size()];
            int result = 0;
            //遍历奇数去匹配偶数
            for(int i = 0; i < odds.size(); i++) {
                //每一步重新创建，也就是相当于清空
                //used数组用于标记某个某数位置是否
                int[] used = new int[evens.size()];
                //这里采用了匈牙利算法，先到先得
                if(find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    //判断是否为素数
    public static boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
            if(num == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param x 奇数值
     * @param evens 偶数集合
     * @param used 偶数是否匹配过奇数。记录下标值
     * @param evensMatch
     * @return
     */
    public static boolean find(int x, List<Integer> evens,int[] used, int[] evensMatch) {
        //遍历偶数
        //去检查当前传入的奇数能否与偶数哪些数匹配
        for(int i = 0; i < evens.size(); i++) {
            //如果当前偶数与传入的奇数匹配，并且当前偶数位还没有匹配过奇数
            if(isPrime(x + evens.get(i)) && used[i] == 0) {
                used[i] = 1;
                if(evensMatch[i] == 0 || find(evensMatch[i], evens, used, evensMatch)) {
                    evensMatch[i] = x;
                    return true;
                }
            }
        }
        return false;
    }
}



