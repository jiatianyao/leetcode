package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ90 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) != null) {
            String[] split = str.split("\\.");
            boolean flag = false;
            for (int i = 0; i < split.length; i++) {
                if(flag) break;
                String s = split[i];
                int len = s.length();
                while (len>0){
                    char c = s.charAt(len-1);
                    len--;
                    if (c > '9' || c < '0'){
                        flag = true;
                        break;

                    }else{
                        continue;
                    }

                }
                if(flag) break;
                int j = Integer.parseInt(s);
                if(j>255){
                    flag =true;
                    break;
                }

            }
            if(!flag)
            System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
