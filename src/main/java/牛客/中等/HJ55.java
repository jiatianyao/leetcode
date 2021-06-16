package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月26日 20:30:47
 * 2021年4月26日 20:33:50
 */
public class HJ55 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int count = 0;
            int i = Integer.parseInt(str1);
            for (int j = 1; j <= i; j++) {
                if(j % 7 ==0){
                    count++;
                }else if((""+j).contains("7")){
                    count++;
                }

            }
            System.out.println(count);
        }
    }
}
