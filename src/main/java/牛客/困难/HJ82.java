package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ82 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String res = "";
            String[] s = str1.split("/");
            Integer a = Integer.parseInt(s[0]);
            Integer b = Integer.parseInt(s[1]);

            while (true){
                int c = b/a+1;
                res += "1/";
                res += c;
                a = a - b % a;
                b = b * c;
                res += "+";
                if (a == 1){
                    res += "1/";
                    res += b;
                    break;
                }else if (a > 1 && b % a == 0){
                    res += "1/";
                    res += b/a;
                    break;
                }
            }

            System.out.println(res);
        }
    }

}
