package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ87 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";


        while((str1 =  reader.readLine()) !=null){
            int upperLetter = 0;
            int lowerLetter = 0;
            int digit = 0;
            int symbol = 0;
            int length = str1.length();
            for (int i = 0; i < length; i++) {
                char c = str1.charAt(i);
                if(Character.isLowerCase(c)){
                    upperLetter++;
                }
                if(Character.isUpperCase(c)){
                    lowerLetter++;
                }
                if(Character.isDigit(c)){
                    digit++;
                }
                if( (c >= 0x21 && c <=0x2F) ||  (c >= 0x3A && c <=0x40)  ||  (c >= 0x5B && c <=0x60)   ||  (c >= 0x7B && c <=0x7E)  ){
                    symbol++;
                }
            }
            int score = 0;
            if(length >=8){
                score+=25;
            }else if(length >=5){
                score+=10;
            }else if(length <=4 ){
                score+=5;
            }
            if(upperLetter>0 && lowerLetter > 0 ){
                score+= 20;
            }else if(upperLetter>0 || lowerLetter > 0 ){
                score+= 10;
            }
            if(digit>1){
                score+= 20;
            }else if(digit==1){
                score+= 10;
            }
            if(symbol>1){
                score+= 25;
            }else if(symbol==1){
                score+= 10;
            }

            if(upperLetter>0 && lowerLetter > 0 && symbol>0 && digit > 0 ){
                score+= 5;
            }else if((upperLetter>0 || lowerLetter > 0) && symbol>0 && digit > 0 ){
                score+= 3;
            }else if((upperLetter>0 || lowerLetter > 0) && digit>0){
                score+= 2;
            }
            if(score >=90){
                System.out.println("VERY_SECURE");
            }else if(score >=80){
                System.out.println("SECURE");
            }else if(score >=70){
                System.out.println("VERY_STRONG");
            }else if(score >=60){
                System.out.println("STRONG");
            }else if(score >=50){
                System.out.println("AVERAGE");
            }else if(score >=25){
                System.out.println("WEAK");
            }else if(score >=0){
                System.out.println("VERY_WEAK");
            }


        }
    }

}
