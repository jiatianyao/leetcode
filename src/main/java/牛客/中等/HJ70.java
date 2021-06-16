package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * 本题含有多组样例输入！
 * 输入描述:
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 *
 * 输出描述:
 * 输出需要进行的乘法次数
 */
public class HJ70 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int i = Integer.parseInt(str1);
            String[] n = new String[i];
            for (int j = 0; j <i; j++) {
                String str = reader.readLine();
                n[j] = str;
            }
            String str = reader.readLine();
            Deque<Character> stack = new LinkedList<>();
            String res = "";
            for (int j = str.length()-1; j>=0; j--) {
                char c = str.charAt(j);
                if(c ==')'){
                    continue;
                }else if(c == '('){
                    while(!stack.isEmpty()){
                        Character pop = stack.pop();
                        if(pop ==')') {
                            if(res.equals("")){
                                stack.push(pop);
                            }
                            break;
                        }
                        if(res.equals("")){
                            res =  n[pop-'A'];
                        }else{
                            String[] s1 = res.split(" ");
                            String[] s2 = n[pop - 'A'].split(" ");
                            res = (Integer.parseInt(s1[0])  * Integer.parseInt(s1[0]) +" "
                                    +(Integer.parseInt(s1[1])) * Integer.parseInt(s2[1]));
                        }
                    }
                }else{
                    stack.push(c);
                }
            }
        }
    }
}
