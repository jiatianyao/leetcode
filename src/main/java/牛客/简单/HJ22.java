package 牛客.简单;

import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int res = 0;
            int n = in.nextInt();
            if(n==0)
                continue;
            while(n>=3){
                int qishui = n/3;
                res += qishui;
                n = qishui + n% 3;
            }
            if(n==2){
                res++;
            }

            System.out.println(res);
        }
    }
}
