package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class HJ80_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            Integer m = Integer.parseInt(str1);
            String str2 = reader.readLine();
            Integer n = Integer.parseInt(reader.readLine());
            String str3 = reader.readLine();
            String[] s1 = str2.split(" ");
            String[] s2 = str3.split(" ");
            Integer[] str = new Integer[m+n];
            for (int i = 0; i < s1.length; i++) {
                str[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < s2.length; i++) {
                str[m+i] = Integer.parseInt(s2[i]);
            }
            Arrays.sort(str);
            int last = 0;
            for (int i = 0; i < str.length; i++) {
                int s = str[i];
                if(last!=s){
                    last = s;
                    System.out.print(s);
                }

            }
            System.out.println();


        }
    }

}
