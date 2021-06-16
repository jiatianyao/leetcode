package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ51 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int len = Integer.parseInt(str1);
            int n = len;
            String str2=  reader.readLine();
            String[] a = str2.split(" ");
            String str3=  reader.readLine();
            Integer k = Integer.parseInt(str3);
            if(k==0){
                System.out.println(0);
            }else if(k<len){
                int i = 0;
                while(k!=n){
                    i++;
                    k++;
                }
                System.out.println(a[i]);
            }
        }
    }

}
