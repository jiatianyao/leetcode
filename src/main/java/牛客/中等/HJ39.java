package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月17日23:24:13
 * 2021年4月18日00:17:13
 *
 * HJ39 判断两个IP是否同一个子网掩码
 * 题目描述
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断
 * 两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 * I P 地址　11010000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 * AND运算
 * 11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 * I P 地址　11010000.10101000.00000000.11111110
 * 子网掩码　11111111.11111111.11111111.00000000
 * AND运算
 * 11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 * 192.168.0.0
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。
 * 均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 *
 * 输入描述:
 * 输入子网掩码、两个ip地址
 *
 * 输出描述:
 * 得到计算结果
 *
 * 示例1
 * 输入
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 复制
 * 1
 * 2
 */
public class HJ39 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 = reader.readLine();
            String str3 = reader.readLine();
            String[] s =  str1.split("\\.");
            String[] s1 = str2.split("\\.");
            String[] s2 = str3.split("\\.");
            if(!(    (Integer.parseInt(s[0]) >=0 && Integer.parseInt(s[0])<= 255 ) &&
                    (Integer.parseInt(s[1]) >=0 && Integer.parseInt(s[1])<= 255 ) &&
                    (Integer.parseInt(s[2]) >=0 && Integer.parseInt(s[2])<= 255 ) && Integer.parseInt(s[0]) >= Integer.parseInt(s[1] )
                    && Integer.parseInt(s[1]) >= Integer.parseInt(s[2]) && Integer.parseInt(s[2]) >= Integer.parseInt(s[3]) &&
                    (Integer.parseInt(s[3]) >=0 && Integer.parseInt(s[3])<= 255 )) ){
                System.out.println(1);
            }else if(Integer.parseInt(s1[0]) >255 || Integer.parseInt(s1[0]) <0 ||
                     Integer.parseInt(s1[1]) >255 || Integer.parseInt(s1[1]) <0 ||
                     Integer.parseInt(s1[2]) >255 || Integer.parseInt(s1[2]) <0 ||
                     Integer.parseInt(s1[3]) >255 || Integer.parseInt(s1[3]) <0 ){
                System.out.println(1);
            }else if(Integer.parseInt(s2[0]) >255 || Integer.parseInt(s2[0]) <0 ||
                     Integer.parseInt(s2[1]) >255 || Integer.parseInt(s2[1]) <0 ||
                     Integer.parseInt(s2[2]) >255 || Integer.parseInt(s2[2]) <0 ||
                     Integer.parseInt(s2[3]) >255 || Integer.parseInt(s2[3]) <0 ){
                System.out.println(1);
            }else if(
                    ((Integer.parseInt(s1[0]) & Integer.parseInt(s[0])) == (Integer.parseInt(s2[0])& Integer.parseInt(s[0]))) &&
                    ((Integer.parseInt(s1[1]) & Integer.parseInt(s[1])) == (Integer.parseInt(s2[1])& Integer.parseInt(s[1]))) &&
                    ((Integer.parseInt(s1[2]) & Integer.parseInt(s[2])) == (Integer.parseInt(s2[2])& Integer.parseInt(s[2]))) &&
                    ((Integer.parseInt(s1[3]) & Integer.parseInt(s[3])) == (Integer.parseInt(s2[3])& Integer.parseInt(s[3])))

                    ){
                System.out.println(0);
            }else{
                System.out.println(2);
            }
        }
    }
}

