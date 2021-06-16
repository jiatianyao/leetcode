package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 最快速写法
 * 2021年5月3日11:33:32
 * 2021年5月3日11:45:23
 */
public class HJ29_2 {
    private static String x = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String y = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 = reader.readLine();
            String res1 = jiami(str1);
            String res2 = jiemi(str2);
            System.out.println(res1);
            System.out.println(res2);
        }
    }

    private static String jiami(String str1) {
        String res = "";
        char[] chars = x.toCharArray();
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            char c = str1.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(c==aChar){
                    res += y.charAt(j);
                    break;
                }
            }

        }
        return res;

    }


    private static String jiemi(String str2) {
        String res = "";
        char[] chars = y.toCharArray();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char c = str2.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(c==aChar){
                    res += x.charAt(j);
                    break;
                }
            }

        }
        return res;

    }
}
