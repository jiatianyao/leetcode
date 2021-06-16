package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ13_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){

            String[] s = str1.split(" ");
            int length = s.length;
            for (int i = length-1; i>= 0; i--) {
                String s1 = s[i];
                System.out.print(s1+" ");

            }

        }
    }
}
