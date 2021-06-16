package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 2021年4月18日 19:26:53
 * 2021年4月18日 20:07:55
 */
public class HJ92 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int length = str1.length();
            int res = 0;
            List<String> list = new ArrayList<>();
            int max =0;
            String str = "";
            for (int i = 0; i < length; i++) {
                char c = str1.charAt(i);
                if(Character.isDigit(c)){
                    res++;
                    str+=c;
                    if(res > max){
                        list = new ArrayList<>();
                        list.add(str);
                        max = res;
                    }else if (res == max){
                        list.add(str);
                    }

                }else{
                    str="";
                    res =0;
                }

            }

            for (String s : list) {
                System.out.print(s);
            }
            System.out.print(",");
            System.out.print(max);
            System.out.println();
        }
    }

}
