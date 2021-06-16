package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 */
public class HJ17_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        String regex = "[ASWD]\\d{1}\\d?";
        while((str1 =  reader.readLine()) !=null){
            int x = 0;
            int y = 0;
            String[] split = str1.split(";");
            for (int i = 0; i < split.length; i++) {
                boolean flag = true;
                String s = split[i];
                if(!s.matches(regex)) continue;
                int n = Integer.parseInt( s.substring(1));
                if (s.startsWith("A")) {
                    x -= n;
                } else if (s.startsWith("D")) {
                    x += n;
                } else if (s.startsWith("W")) {
                    y += n;

                } else if (s.startsWith("S")) {
                    y -= n;
                }
            }
            System.out.println(x+","+y);
        }
    }

}
