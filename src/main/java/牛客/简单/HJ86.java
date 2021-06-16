package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ86 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String s = Integer.toBinaryString(Integer.parseInt(str1));
            String[] split = s.split("0");
            int max = 0;
            for (String s1 : split) {
                if(s1.length()>max){
                    max = s1.length();
                }
            }
            System.out.println(max);
        }
    }
}
