package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ58_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            String str2 =  reader.readLine();
            String[] s1 = str2.split(" ");
            int [] a = new int[n];
            for (int i = 0; i < s1.length; i++) {
                a[i] = Integer.parseInt(s1[i]);

            }
            Arrays.sort(a);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(a[i]);
                sb.append(" ");

            }
            System.out.println(sb.toString().trim());
        }
    }

}
