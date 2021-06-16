package 牛客.入门;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int i = in.nextInt();
            String s = Integer.toBinaryString(i);
            int length = s.length();
            int count = 0;
            while( length>0){
                String substring = s.substring(length-1, length);
                if(substring.equals("1")){
                    count++;
                }
                length--;
            }
            System.out.println(count);
        }
    }
}
