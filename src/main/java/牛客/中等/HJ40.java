package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ40 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int length = str1.length();
            String nochinese = str1.replaceAll("[\\u4e00-\\u9fa5A-Za-z]", "");
            System.out.println(length-nochinese.length());
            String nospace = nochinese.replaceAll(" ", "");
            System.out.println(nochinese.length()-nospace.length());
            String nonum = nospace.replaceAll("\\d", "");
            System.out.println(nospace.length()-nonum.length());
            System.out.println(nonum.length());

        }
    }
}
