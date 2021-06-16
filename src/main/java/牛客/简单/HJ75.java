package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ75 {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str1 ="";
            while((str1 =  reader.readLine()) !=null){
                String str2 = reader.readLine();
                if(str1.length()>str2.length())
                {
                    String temp = str2;
                    str2 = str1;
                    str1 = temp;

                }
                int maxLen = 0;
                String res ="";
                for (int i = 0; i < str1.length(); i++) {
                    for (int j = i+1; j < str1.length(); j++) {
                        String compare = str1.substring(i,j);
                        if(str2.contains(compare) && maxLen < compare.length()){
                            maxLen = compare.length();
                            res = compare;
                        }

                    }

                }
                System.out.println(res);
            }



    }
}
