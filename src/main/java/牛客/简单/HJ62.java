package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 *
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 *
 * //2021年4月11日00:09:46
 */
public class HJ62 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = reader.readLine()) !=null){
            int num = Integer.parseInt(str),count=0;
            while (num != 0) {
                if ((num & 1) == 1) count++;
                num = num >>> 1;
            }
            System.out.println(count);
        }
    }
}


