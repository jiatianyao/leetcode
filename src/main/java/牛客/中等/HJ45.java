package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ45 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            Integer k = Integer.parseInt( str1);
            while(k>0){
                k--;
                String s = reader.readLine();
                int res=0;
                int[] arr = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    System.out.println(s.charAt(i));
                    System.out.println(s.charAt(i)-'a');
                    arr[s.charAt(i)-'a']++;
                }
                Arrays.sort(arr);
                int piaoliang = 26;
                for (int i = arr.length-1; i >=0; i--) {
                   int x =  arr[i];
                   if(x !=0){
                       res +=x * piaoliang;
                   }
                   piaoliang--;

                }

                System.out.println(res);
            }

        }
    }
}
