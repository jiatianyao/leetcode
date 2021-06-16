package 牛客.简单;

import java.util.Scanner;

public class HJ37_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int month = in.nextInt();
            System.out.println(getTuzi(month));
        }
    }

    public static int getTuzi(int month){
        if(month<=2) return 1;
        else return getTuzi(month-1)+getTuzi(month-2);
    }
}
