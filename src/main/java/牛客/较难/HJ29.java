package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 2021年4月16日23:57:26
 * 2021年4月17日00:46:59
 */
public class HJ29 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 = reader.readLine();
            String res1 = jiami(str1);
            String res2 = jiemi(str2);
            System.out.println(res1);
            System.out.println(res2);
        }
    }

    private static String jiami(String str1) {
        String res = "";
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            char c = str1.charAt(i);
            if(Character.isDigit(c)){
                if(c =='9'){
                    res+=0;
                }else{
                    res+=(char)(c+1);
                }
            }else if(Character.isLetter(c)){
                if(c>='a' && c<'z'){
                    res += (char)(c+1-32);
                }else if(c =='z'){
                    res+="A";
                }else if(c =='Z') {
                    res += "a";
                }
                else if(c>='A' && c<'Z'){
                    res += (char)(c+1+32);
                }

            }else{
                res += c;
            }

        }
        return res;

    }


    private static String jiemi(String str1) {
        String res = "";
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            char c = str1.charAt(i);
            if(Character.isDigit(c)){
                if(c =='0'){
                    res+=9;
                }else{
                    res+=(char)(c-1);;
                }
            }else if(Character.isLetter(c)){
                if(c>'A' && c<='Z'){
                    res += (char)(c-1+32);
                }else if(c =='a') {
                    res += "Z";
                }else if(c =='A') {
                    res += "z";
                }else {
                    res += (char)(c-1-32);
                }

            }else{
                res += c;
            }

        }
        return res;

    }
}
