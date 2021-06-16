package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ23 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int len = str1.length();
            int[] ch = new int[26];
            for (int i = 0; i < len; i++) {
                char c = str1.charAt(i);
                ch[c-'a']++;
            }

            int i = 0;
            for (int c : ch) {
                if(c ==0) continue;
                if(i==0) i = c;

                i = Math.min(c,i);
            }

            for (int j = 0; j < ch.length; j++) {
                int ch1 = ch[j];
                if(ch1==i){
                    char x = (char)(j+'a');
                    str1 = str1.replace(""+x,"");
                }
            }
            System.out.println(str1);
        }
    }
}
