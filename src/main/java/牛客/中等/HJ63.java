package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ63 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){

            String str2 = reader.readLine();
            int i = Integer.parseInt(str2);
            int maxLength = 0;
            int begin = 0;
            for (int j = 0; j < str1.length()-i; j++) {
                String substring = str1.substring(j, j + i);
                char[] chars = substring.toCharArray();
                int len = 0;
                for (char c : chars) {
                    if(c =='C'||c =='G'){
                        len++;
                    }
                }
                if(len>maxLength){
                    maxLength = len;
                    begin = j;
                }


            }
            System.out.println(str1.substring(begin,begin+i));
        }
    }
}
