package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ17 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int x = 0;
            int y = 0;

            String[] split = str1.split(";");
            for (int i = 0; i < split.length; i++) {
                boolean flag = true;
                String s = split[i];
                if(s.length() <2 || s.length() >3) {
                    continue;
                }
                String str = s.substring(1);
                if(str.length() ==1){
                    if(!Character.isDigit(str.charAt(0))){
                        flag = false;
                    }
                }else if(str.length() ==2){
                    if(!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(1))){
                        flag = false;
                    }
                }
                if(flag) {
                    int n = Integer.parseInt(str);
                    if (s.startsWith("A")) {
                        x -= n;
                    } else if (s.startsWith("D")) {
                        x += n;
                    } else if (s.startsWith("W")) {
                        y += n;

                    } else if (s.startsWith("S")) {
                        y -= n;
                    } else {
                        flag = false;
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }

}
