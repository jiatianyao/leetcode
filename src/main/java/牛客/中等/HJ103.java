package 牛客.中等;
/**
 * HJ103题目描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。
 * 他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * 本题含有多组样例输入
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 * 输出描述:
 * 输出结果
 * 示例1
 * 输入
 * 6
 * 2 5 1 5 4 5
 * 3
 * 3 2 1
 * 输出
 * 3
 * 1
 * 说明
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ103 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2=  reader.readLine();
            int size = Integer.parseInt(str1);
            int[] a = new int[size];
            String[] s = str2.split(" ");
            for (int i = 0; i < size; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            int[] dp = new int[size];
            for (int i = 0; i < size; i++) {
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(a[j] < a[i]){
                        //最终dp[i]的值为其前面的最大的dp[j] + 1；
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }

            }

            int max = 1;
            for(int i = 0; i < size; i++){
                if(dp[i] > max){
                    max = dp[i];
                }
            }

            System.out.println(max);
        }
    }
}
