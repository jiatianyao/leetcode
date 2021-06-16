package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ4_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int len = str1.length();
            if(len<8){
                while (len<8){
                    str1 = str1+0;
                    len++;
                }
                System.out.println(str1);
            }else{
                while(str1.length()>8){
                    String head = str1.substring(0,8);
                    str1 = str1.substring(8);
                    System.out.println(head);
                }
                if(str1.length() ==0){
                    break;
                }else{
                    int k = str1.length();
                    while (k<8){
                        str1 = str1+0;
                        k++;
                    }
                    System.out.println(str1);
                }

            }
        }
    }
}
