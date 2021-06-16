package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ57 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String result = "";
            String str2 =   reader.readLine().trim();
            str1 = str1.trim();
            int len = str2.length() > str1.length() ? str2.length() : str1.length();
            if(str2.length() > str1.length() ){
                int len1 = str2.length() - str1.length();
                while (len1>0){
                    str1 = "0"+str1;
                    len1--;
                }
            }else{
                int len2 = str1.length() - str2.length();
                while (len2>0){
                    str2 = "0"+str2;
                    len2--;
                }
            }
            int jinwei = 0;
            for (int i =len -1; i >= 0 ; i--) {
                    char c = str1.charAt(i);
                    char c2 = str2.charAt(i);
                    int i1 = c-'0';
                    int i2 = c2-'0';
                    if(i1+i2+jinwei >9){
                        int n = (i1+i2+jinwei)-10;
                        result = n+ result;
                        jinwei =1;
                    }else{
                        result = (i1+i2+jinwei) +result;
                        jinwei = 0;
                    }
            }
            if(jinwei ==0) {
                System.out.println(result);
            }else{
                System.out.println("1"+result);
            }
        }
    }
}


