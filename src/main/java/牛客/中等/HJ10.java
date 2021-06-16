package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int length = str.length();
        int [] a = new int[128];
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            a[Integer.valueOf(c)]++;
        }
        int res = 0;
        Arrays.sort(a);
        for (int i = a.length-1; i>=0; i--) {
            int i1 = a[i];
            if(i1>0){
                res++;
            }else{
                break;
            }
        }
        System.out.println(res);
    }
}
