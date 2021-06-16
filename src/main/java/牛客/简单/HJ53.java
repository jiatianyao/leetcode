package 牛客.简单;


import java.util.Scanner;

//杨辉三角规律                                    行号    第一个偶数在该行第几个
//                    1                           1             -1
//                1   1   1                       2             -1
//            1   2   3   2   1                   3              2
//         1  3   6   7   6   3   1               4              3
//      1  4  10  16  19  16  10  4  1            5              2
//   1  5  15 30  45  51  45  30  15 5  1         6              4
//
//  首个偶数在该行第几个的规律： -1 -1 （2 3 2 4）···（2 3 2 4）

/**
 * 输入描述:
 * 输入一个int整数
 * 输出描述:
 * 输出返回的int值
 * 示例1
 * 输入
 * 4
 * 2
 * 输出
 * 3
 * -1
 */
public class HJ53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] res = new int[]{2,3,2,4};
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n<=2) System.out.println(-1);
            System.out.println(res[(n+1)%4]);
        }
    }
}




