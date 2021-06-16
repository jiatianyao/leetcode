package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串运用-密码截取
 * 2021年4月25日21:17:33
 * 2021年4月25日21:26:58
 *
 */

public class HJ85_easy {
    public static int maxLen = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            maxLen = 0;
            for (int i = 0; i < str1.length(); i++) {
                for (int j = i+2; j < str1.length(); j++) {
                    String str2 = str1.substring(i, j);
                    boolean flag =  isPalindrome(str2);
                    if(flag && str2.length() > maxLen){
                        maxLen = str2.length();
                    }
                }

            }
            if(maxLen >0)//这个应该是题目的BUG，没说为0不输出，但是需要判断为0不输出
            System.out.println(maxLen);
        }
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        int i = 0;
        int j = length-1;
        while(i<j){
            if(i==j){
                return true;
            }
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
