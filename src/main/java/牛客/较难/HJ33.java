package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//整数与IP地址间转换
public class HJ33 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 =reader.readLine();
            String[] s = str1.split("\\.");
            int length = s.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                long l = Long.parseLong(s[i]);
                String s1 = Long.toBinaryString(l);
                String temp = String.format("%08d", Long.parseLong(s1));
                sb.append(temp);
            }
            long l = Long.parseLong(sb.toString(),2);
            System.out.println(l);

            //先转换为2进制
            String s1 = Long.toBinaryString(Long.parseLong(str2));
            String s2="";
            if(s1.length()<32){
                int len = s1.length();
                while (32- len>0){
                    s2+="0";
                    len++;
                }
            }
            s2 = s2+s1;
            String ip1 = s2.substring(0,8);
            String ip2 = s2.substring(8,16);
            String ip3 = s2.substring(16,24);
            String ip4 = s2.substring(24,32);
            long l1 = Long.parseLong(ip1,2);
            long l2 = Long.parseLong(ip2,2);
            long l3 = Long.parseLong(ip3,2);
            long l4 = Long.parseLong(ip4,2);
            System.out.println(l1+"."+l2+"."+l3+"."+l4);
        }
    }
}
