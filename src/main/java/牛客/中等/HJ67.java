package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年5月5日10:46:40
 * 2021年5月5日12:07:45
 * HJ67 24点游戏算法
 *
 * 题目描述
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字。
 * 输出：
 * true or false
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入4个int整数
 *
 * 输出描述:
 * 返回能否得到24点，能输出true，不能输出false
 * 示例1
 * 输入
 * 7 2 1 10
 * 输出
 * true
 */
public class HJ67 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str ="";
        while((str =  reader.readLine()) !=null){
            String[] s = str.split(" ");
            int length = s.length;
            int[] n = new int[length];
            for (int i = 0; i < length; i++) {
                n[i] = Integer.parseInt(s[i]);
            }
            int[] visted = new int[length];
            boolean flag = false;//是否存在24点
            for (int i = 0; i < length; i++) {
                int selectNum = n[i];
                visted[i]=1;
                boolean ok = isOk(n, visted, selectNum);
                if(ok){
                    flag = true;
                    break;
                }else{
                    //回溯
                    visted[i]=0;
                }
            }
            System.out.println(flag);
        }
    }

    public static boolean isOk(int[] n,int[] visted,int sum){
        int isAllVisted = 0;
        for (int i = 0; i < visted.length; i++) {
            int x = visted[i];
            if(x==1){
                isAllVisted++;
            }else{
                break;
            }
        }
        if(isAllVisted ==4){
            return sum == 24;
        }

        for (int i = 0; i < n.length; i++) {
            int j = n[i];
            if(visted[i] ==1){
                continue;
            }
            visted[i] = 1;
            boolean flag = isOk(n,visted,sum+j) ||  isOk(n,visted,sum-j) ||  isOk(n,visted,sum*j)
                    ||  (j != 0 && sum % j == 0 && isOk(n,visted,sum/j));
            if(flag) return true;
            visted[i] = 0;//回溯

        }
        return false;
    }
}





