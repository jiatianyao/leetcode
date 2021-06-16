package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ46 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
           Integer k = Integer.parseInt( reader.readLine());
            System.out.println(str1.substring(0,k));
        }
    }
}
