package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 2021年5月3日13:00:40
 * 2021年5月3日13:13:42
 */
public class HJ362 {
    private static String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            char[] x = key.toCharArray();
            char[] y = new char[26];
            char[] chars1 = str1.toCharArray();
            Set<Character> set = new HashSet();
            int n = 0;
            for (int i = 0; i < chars1.length; i++) {
                char c = Character.toUpperCase(chars1[i]);
                if(set.contains(c)){
                    continue;
                }
                set.add(c);
                y[n] = c;
                n++;
            }
            for (int i = 0; i < x.length&& n<26; i++) {
                char c = x[i];
                if(set.contains(c)){
                    continue;
                }
                y[n] =c;
                n++;
            }
            String str2 =  reader.readLine();
            char[] chars2 = str2.toCharArray();
            for (int i = 0; i < chars2.length; i++) {
                char c = chars2[i];
                if(Character.isLetter(c)){
                    if(Character.isUpperCase(c)){
                        int i1 = key.indexOf(c);
                        System.out.print(y[i1]);
                    }else{
                        int i1 = key.indexOf(Character.toUpperCase(c));
                        System.out.print(Character.toLowerCase(y[i1]));
                    }
                }else{
                    System.out.print(c);
                }



            }
            System.out.println();
        }
    }

}
