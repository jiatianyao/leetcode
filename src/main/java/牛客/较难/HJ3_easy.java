package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ3_easy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int len = Integer.parseInt(str1);
            int[] ins = new int[1001];
            for (int j = 0; j < len; j++) {
                int n = Integer.parseInt(reader.readLine());
                ins[n] = 1;
            }

            for(int i =0; i< 1000;i++ ){
                if(ins[i] == 1)
                    System.out.println(i);
            }

        }
    }
}
