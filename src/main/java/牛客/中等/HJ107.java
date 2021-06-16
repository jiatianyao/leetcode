package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ107题目描述
 * 计算一个数字的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 输入描述:
 * 待求解参数，为double类型（一个实数）
 *
 * 输出描述:
 * 输入参数的立方根。保留一位小数。
 *
 * 示例1
 * 输入
 * 216
 * 输出
 * 6.0
 */
public class HJ107 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double d = Double.parseDouble(s);
        //0.1*0.1*0.1=0.0001
        double l = 0.0, r = d;
        while (r - l > 0.0001) {
            double mid = (r + l) / 2;
            if(Math.pow(mid, 3) < d){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(Math.pow(Math.round(r),3) == d){ //216的开方 6.0，精益求精，5.9
            System.out.printf("%.1f", (double) Math.round(r));
        }else{
            System.out.printf("%.1f", r);
        }
    }

    public void fangfa2() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double num = Double.parseDouble(s);
        double x= 1.0;
        for (;Math.abs(Math.pow(x,3) -num) > 1e-3; x=x-((Math.pow(x,3)-num)/(3*Math.pow(x,2))));
        System.out.println(String.format("%.1f",x));
    }
}
