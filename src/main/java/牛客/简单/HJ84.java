package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ84 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int length = str1.length();
            str1 = str1.replaceAll("[A-Z]+","");
            System.out.println(length-str1.length());
//            int count = 0;
//            for (int i = 0; i < str1.length(); i++) {
//                if (Character.isUpperCase(str1.charAt(i))) {
//                    count++;
//                }
//            }
//            System.out.println(count);
        }
    }
}
