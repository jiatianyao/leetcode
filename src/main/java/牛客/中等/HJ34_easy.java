package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月22日23:30:11
 * 2021年4月23日00:01:13
 */
public class HJ34_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = reader.readLine()) !=null){
            int[] x = new int[132];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if(Character.isDigit(c)){
                    x[Integer.parseInt(Character.toString(c))] ++;
                }else{
                    x[c-'A'+10]++;
                }

            }
            for (int i = 0; i < x.length; i++) {
                int n = x[i];
                while(n>0){

                    if(i<=9) {
                        System.out.print( i);
                    }else{
                        System.out.print(Character.toChars( i+65-10));
                    }
                    n--;
                }
            }
            System.out.println();
        }
    }
}
