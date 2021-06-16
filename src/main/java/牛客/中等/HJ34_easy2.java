package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 更快速解答
 * 2021年5月3日12:29:14
 * 2021年5月3日12:30:25
 */
public class HJ34_easy2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = reader.readLine()) !=null){
            int length = str.length();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                System.out.print(aChar);

            }
            System.out.println();
        }
    }
}
