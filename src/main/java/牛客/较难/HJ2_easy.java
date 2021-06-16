package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ2_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str2 = reader.readLine();
        String s = str.toLowerCase();
        String s1 = str2.toLowerCase();
        int res = 0;
        while(s.contains(s1)){
            s= s.substring(s.indexOf(s1)+1);
            res++;
        }
        System.out.println(res);
    }
}
