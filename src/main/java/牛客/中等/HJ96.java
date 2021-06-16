package 牛客.中等;


/**
 * 题目描述
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 * 注意：本题有多组样例输入。
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * 示例1
 * 输入
 * Jkdi234klowe90a3
 * 5151
 * 输出
 * Jkdi*234*klowe*90*a*3*
 * *5151*
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ96 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Map<Integer, Integer> zishoushu = new HashMap<>();
        Map<Integer, Integer> all = new HashMap<>();
        while ((str = reader.readLine()) != null) {
            boolean flag = false;
            String res = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(Character.isDigit(c)){
                    if(!flag) {
                        res += "*" + c;
                    }else{
                        res+= c;
                    }
                    flag = true;
                }else{
                    if(flag){
                        res += "*" + c;
                        flag = false;
                    }else{
                        res+= c;
                    }

                }

            }
            if(flag)  res += "*";
            System.out.println(res);
        }
    }
}
