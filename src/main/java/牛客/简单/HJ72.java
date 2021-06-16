package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ72百钱买百鸡
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * 输入描述:
 * 输入一个整数
 *
 * 输出描述:
 * 计算整数二进制中1的个数
 */

/**
 * 5x+3y+1/3z=100;
 * x+y+z=100;
 * 15x+9y+z =300;
 * 14x+8y =200;
 * 7x+4y =100;
 * x<=14 y<=25
 */
public class HJ72 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        for(int n1 = 0 ; n1 < 14;n1++){
            for(int n2 = 0; n2 <= 25;n2++){
                if(7*n1+4*n2==100){
                    int n3 = 100 - n1 - n2;
                    System.out.println(n1+" "+n2+" "+n3);
                }
            }
        }

    }
}

