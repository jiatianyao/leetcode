package 牛客.简单;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\ d:\，
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\
 * 参数4: 字符串d:\
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。

 * 解析规则：
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy
 * /s “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，
 * 而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 */
//2021年4月11日 09:26:07
public class HJ74_keng {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] s = str.split(" ");
        String[] res = new String[s.length];
        String res2 = "";
        int i =0;
        for (String s1 : s) {
            if(s1.startsWith("\"") && s1.endsWith("\"")){
                res[i] = s1.replaceAll("\"","");
                i++;
            }else if(s1.startsWith("\"")){
                res2 += s1;
            }else if(s1.endsWith("\"") ){
                res2 += s1;
                res[i] = res2.replaceAll("\"","");
                res2="";
                i++;
            }else if( res2.length() > 0 ){
                res2 += s1;
            }
            else{
                res[i] = s1;
                i++;
            }
        }
        System.out.println(i);
        for (String re : res) {
            if (re!=null) {
                System.out.println(re);
            }
        }
    }
}


