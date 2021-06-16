package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 记负均正II
 * 2021年4月18日23:26:12
 * 2021年4月18日23:36:00
 */
public class HJ105 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        int negative = 0;
        int negativeNum = 0;//负数个数
        int positive = 0;
        int positiveNum = 0;
        while((str1 =  reader.readLine()) !=null){//这道题最坑的是这个地方，结束不了也能过！！！！
            int x = Integer.parseInt(str1);
            if(x>0){
                positiveNum++;
                positive+=x;
            }else if(x<0){
                negativeNum++;
            }

        }
        System.out.println(negativeNum);
        System.out.printf("%.1f",(double)positive/positiveNum);

    }
}
