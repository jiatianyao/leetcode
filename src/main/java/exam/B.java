package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine())!=null) {
            String regex = "[^0-9a-z]";
            Pattern compile = Pattern.compile(regex);
            boolean flag = true;
            if(compile.matcher(str).find()){
                System.out.println("!error");
                flag = false;
            }


            if(!flag) continue;
            char[] chars = str.toCharArray();
            int time = 0;
            StringBuilder result = new StringBuilder();
            char lastChar = 'A';
            int lastCharTimes = 0;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if(Character.isDigit(aChar)){
                    if(time>0){
                        time = time * 10 +(aChar  -'0');
                    }else{
                        time = aChar -'0';
                    }

                }else if(Character.isLetter(aChar)){
                    if(lastChar == aChar){
                        if(lastCharTimes>=2){
                            System.out.println("!error");
                            flag = false;
                            break;
                        }
                        lastCharTimes++;
                    }else{
                        lastChar = aChar;
                        lastCharTimes=1;
                    }

                    if(time ==0){
                        result.append(aChar);
                    }else if(time <=2){
                        System.out.println("!error");
                        flag = false;
                        break;
                    } else{
                        //d3df ok?
                        lastCharTimes+=time;

                        while(time>0){
                            result.append(aChar);
                            time--;
                        }
                    }
                }else{
                    System.out.println("!error");
                    flag = false;
                    break;
                }

            }
             if(flag) {
                 if(Character.isDigit(chars[chars.length-1])){
                     System.out.println("!error");
                 }else{
                     System.out.println(result.toString());
                 }


            }
        }
    }
}