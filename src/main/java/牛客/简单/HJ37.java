package 牛客.简单;

import java.util.Scanner;


/**
 * 递归推倒
 *
 *
 * 本月兔子 = 本月成年+本月幼年
 * 本月成年 = 上个月成年+上个月幼年
 * 本月幼年 = 上年成年兔子  = 上上年成年+上上年幼年
 *
 * f(n) = f(n-1)+f(n-2)
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int endmonth = in.nextInt();
            int oneMonth = 1;
            int twoMonth = 0;
            int threeMonth = 0;
            int bornMonth = 0;
            int startMonth = 1;
            while (startMonth < endmonth) {
//            System.out.println(startMonth);
                int currentBorn = 0;
                currentBorn = threeMonth + twoMonth;
                threeMonth = twoMonth + threeMonth;
                twoMonth = oneMonth;
                oneMonth = currentBorn;
                startMonth++;
            }
            System.out.println(oneMonth + twoMonth + threeMonth);
        }
    }
}
