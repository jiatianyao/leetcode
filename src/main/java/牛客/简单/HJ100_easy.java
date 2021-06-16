package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月24日20:21:23
 * 2021年4月24日20:33:20
 */
public class HJ100_easy {
    public static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            sum=0;
            int i = Integer.parseInt(str1);
            int n = getSum(i);
            System.out.println(sum);
        }
    }

    private static int getSum(int i) {
        if(i==1){
            sum+= 2;
            return 2;
        }
        int i1 = getSum(i - 1) + 3;
        sum = sum+i1;
        return i1;
    }


}
