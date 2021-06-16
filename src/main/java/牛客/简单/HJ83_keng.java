package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月25日20:39:01
 * 2021年4月25日21:04:02
 */
public class HJ83_keng {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            if(m!=0 && n!=0){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
            String str2 = reader.readLine();
            String[] s2 = str2.split(" ");
            if(Integer.parseInt(s2[0]) <m && Integer.parseInt(s2[1]) <n && Integer.parseInt(s2[2]) <m && Integer.parseInt(s2[3]) <n){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
            String str3 = reader.readLine();
            String str4 = reader.readLine();
            if(Integer.parseInt(str3) <m && m+1 <=9){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
            if(Integer.parseInt(str4) <n  && n+1 <=9){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
            String str5 = reader.readLine();
            String[] s5 = str5.split(" ");
            if(Integer.parseInt(s5[0]) <m && Integer.parseInt(s5[1]) <n){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
        }
    }
}
