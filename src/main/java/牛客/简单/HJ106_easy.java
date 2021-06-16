package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ106_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            char[] chars = str1.toCharArray();
            for (int i = chars.length-1; i>=0; i--) {
                char aChar = chars[i];
                System.out.print(aChar);

            }
            System.out.println();
        }
    }
}
