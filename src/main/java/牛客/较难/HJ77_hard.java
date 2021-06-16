package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2021年4月18日15:33:09
 * 2021年4月18日16:43:14
 * HJ77火车进站
 * 题目描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，
 * 火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0
 *
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 * 示例1
 * 输入
 * 3
 * 1 2 3
 * 输出
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 说明
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class HJ77_hard {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str = reader.readLine();
            int x = Integer.parseInt(str1);//根本没用，题目给了就读一下吧
            String[] s = str.split(" ");
            List<String> res = new ArrayList<>();
            Deque<String> stack = new LinkedList<>();
            //正文开始，一个递归
            recursion(res,"",stack,s,0,0);
            Collections.sort(res);//排序-以字典序排序输出
            for (String re : res) {
                System.out.println(re.trim());
            }
        }
    }

    ///in为入栈次数，out为出栈次数，str存储一趟结果,res最终结果
    private static void recursion(List<String> res,String str,Deque<String> stack,String[] s,int in,int out){
        if(out == s.length){
            res.add(str);
        }
        if(!stack.isEmpty() ){
            String temp = stack.pop();
            recursion(res,str +" "+ temp,stack,s,in,out+1);
            stack.push(temp);//恢复现场
        }
        if(in < s.length){
            stack.push(s[in]);
            recursion(res,str,stack,s,in+1,out);
            stack.pop();//恢复现场
        }
    }
}


