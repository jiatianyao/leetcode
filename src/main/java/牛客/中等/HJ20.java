package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class HJ20 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";

        Pattern p1 = Pattern.compile("[^a-zA-Z0-9]");
        Pattern p2 = Pattern.compile("[0-9]");
        Pattern p3 = Pattern.compile("[a-z]");
        Pattern p4 = Pattern.compile("[A-Z]");

        while((str1 =  reader.readLine()) !=null){
            int length = str1.length();
            if(length<8){
                System.out.println("NG");
                continue;
            }
            int count = 0;
            if(p1.matcher(str1).find()){
                count++;
            }
            if(p2.matcher(str1).find()){
                count++;
            }
            if(p3.matcher(str1).find()){
                count++;
            }
            if(p4.matcher(str1).find()){
                count++;
            }
            if(count<3){
                System.out.println("NG");
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < length-2; i++) {
                for (int j = i+1; j < length-3; j++) {
                    String str2 = str1.substring(i, i + 3);
                    String str3 = str1.substring(j, j + 3);
                    if(str2.equals(str3)){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
}
