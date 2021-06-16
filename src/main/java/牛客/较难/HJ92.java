package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ92 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int len = 0;
            String[] split = str1.split("[^0-9]+");
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if(s.length()>0){
                    len=s.length();
                }
            }
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if(s.length() == len){
                    System.out.print(s);
                }
            }
            System.out.print(len);
        }
    }

}
