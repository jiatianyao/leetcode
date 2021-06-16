package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月18日23:01:10
 * 2021年4月18日23:10:13
 */
public class HJ97_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int i = Integer.parseInt(str1);
            String str2 = reader.readLine();
            String[] s = str2.split(" ");
            int positiveNum =0;
            int positiveNumSum =0;
            int negativeNum =0;
            for (int j = 0; j < s.length; j++) {
                int x = Integer.parseInt(s[j]);
                if(x>0){
                    positiveNumSum+=x;
                    positiveNum++;
                }else if(x<0){
                    negativeNum++;
                }

            }
            System.out.print(negativeNum+" ");
            System.out.printf("%.1f" ,(double)positiveNumSum/positiveNum);
            System.out.println();

        }
    }
}
