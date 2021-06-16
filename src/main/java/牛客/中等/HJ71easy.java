package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月18日 19:38:43
 * 2021年4月18日 19:48:36
 */
public class HJ71easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 = reader.readLine();
            int[] a = new int[26];
            for (int i = 0; i < str2.length(); i++) {
                a[str2.charAt(i)-'a']++;

            }
            boolean flag = true;
            for (int i = 0; i < str1.length(); i++) {

                int x = str1.charAt(i)-'a';
                if(a[x] ==0){
                    flag = false;
                }
            }

            System.out.println(flag);
        }
    }

}
