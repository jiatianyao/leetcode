package 牛客.较难;


/**
 * 2021年4月24日00:59:21
 * 2021年4月24日 01:44:12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * HJ30 字符串合并处理
 * 题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 * 将输入的两个字符串合并。
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，
 * 并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
 * 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 * 注意本题含有多组样例输入
 *
 *
 * 输入描述:
 * 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
 * 输出描述:
 * 输出转化后的结果。每组样例输出一行。
 *
 * 示例1
 * 输入
 * dec fab
 * 输出
 * 5D37BF
 */

public class HJ30 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            if (null == s || str1.length() == 0) {
                System.out.println(str1);
                continue;
            }
            String left = s[0];
            String right = s[1];
            int len = left.length() + right.length();
            String str = left+right;
            char[] leftChars = new char[len%2 ==0 ? len/2 : len/2+1];
            char[] rightChars = new char[len/2];
            left = "";
            right = "";

            for (int i = 0; i <len; i++) {
                char c = str.charAt(i);
                if(i%2 ==0){
                    leftChars[i/2] = c;
                }else{
                    rightChars[i/2] = c;
                }
            }

            Arrays.sort(leftChars);
            Arrays.sort(rightChars);
            len = leftChars.length + rightChars.length;
            for (int i = 0; i < len; i++) {
                char x;
                if(i%2 ==0){
                   x= leftChars[i/2];
                }else{
                    x= rightChars[i/2];
                }
                if (String.valueOf(x).matches("[0-9A-Fa-f]")){
                    String res = change(x);
                    System.out.print(res);
                }else{
                    System.out.print(x);
                }
            }
            System.out.println();
        }
    }

    private static String change(char x) {
        int n = Integer.parseInt(String.valueOf(x), 16);
        n = ((n & 0xc) >>> 2) | ((n & 0x3) << 2);
        n = ((n & 0xa) >>> 1) | ((n & 0x5) << 1);
        return Integer.toHexString(n).toUpperCase();
    }


}
