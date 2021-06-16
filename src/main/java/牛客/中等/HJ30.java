package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HJ30 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            String str = s[0]+s[1];
            List<Character> odd = new ArrayList<>();
            List<Character> even = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {

               if(i%2 ==0){
                   even.add(str.charAt(i));
               }else{
                   odd.add(str.charAt(i));
               }

            }
            Collections.sort(odd);
            Collections.sort(even);
            String res = "";
            for (int i = 0; i < even.size() +odd.size(); i++) {
                if(i%2 ==0){
                    res+=even.get(i/2);
                }else{
                    res+=odd.get(i/2+1);
                }

            }

            System.out.println(res);
        }
    }
}
