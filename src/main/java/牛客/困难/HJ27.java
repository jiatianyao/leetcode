package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HJ27 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            int n = Integer.parseInt(s[0]);
            String str = s[s.length-2];
            int k = Integer.parseInt(s[s.length-1]);
            int x = 0;
            boolean flag = false;
            List<String> list = new ArrayList<>();
            for (int i = 1; i < s.length-2; i++) {
                String s1 = s[i];
                if(s1.length() !=str.length() || s1.equals(str)){
                    continue;
                }


                char[] chars = s1.toCharArray();
                char[] chars1 = str.toCharArray();
                Arrays.sort(chars);
                Arrays.sort(chars1);
                String s2 = String.valueOf(chars);
                String s3 = String.valueOf(chars1);
                if(s2.equals(s3)){
                    list.add(s1);
                    if(x==k-1) flag = true;
                    x++;
                }
            }

            System.out.println(x);
            if(flag){
                Collections.sort(list);
                System.out.println(list.get(k-1));
            }else{
                System.out.println();
            }


        }
    }
}
