package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * 2021年4月18日23:14:01
 * 2021年4月18日23:25:01
 */
public class HJ101_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int len = Integer.parseInt(str1);
            int[] a = new int[len];
            String str2 = reader.readLine();
            String[] s = str2.split(" ");
            for (int i = 0; i < s.length; i++) {
                int x = Integer.parseInt(s[i]);
                a[i] = x;
            }

            int sort = Integer.parseInt(reader.readLine());
            Arrays.sort(a);
            StringBuilder sb = new StringBuilder();
            if(sort ==0) {

                for (int i = 0; i < a.length; i++) {
                    sb.append(a[i]);
                    sb.append(" ");

                }

            }else{
                for (int i = a.length-1; i >=0 ; i--) {
                    sb.append(a[i]);
                    sb.append(" ");

                }
            }
            System.out.println(sb.toString().trim());

        }
    }

}
