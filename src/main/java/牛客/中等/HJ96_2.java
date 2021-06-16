package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ96_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            System.out.println(str1.replaceAll("([0-9]+)","*$1*"));//注意需要加()才能分组，后面$1才能取到
        }
    }
}
