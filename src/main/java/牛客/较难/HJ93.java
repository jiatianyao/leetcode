package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * 2021年4月18日 20:13:14
 * 2021年4月18日20:44:07
 *
 * HJ93数组分组
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，
 * 所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
 * 本题含有多组样例输入。
 * 输入描述:
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述:
 * 返回true或者false
 *
 * 示例1
 * 输入
 * 4
 * 1 5 -5 1
 * 3
 * 3 5 8
 * 输出
 * true
 * 说明
 * 第一个样例：
 * 第一组：5 -5 1
 * 第二组：1
 * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
 */
public class HJ93 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 = reader.readLine();
            Integer m = Integer.parseInt(str1);
            int x = 0;
            int y = 0;
            String[] s = str2.split(" ");
            Deque<Integer> remaining = new LinkedList<>();
            for (int i = 0; i < s.length; i++) {
                String s1 = s[i];
                int i1 = Integer.parseInt(s1);
                if(i1% 5 ==0){
                    x += i1;
                }else if(i1% 3 ==0){
                    y += i1;
                }else{
                    remaining.add(i1);
                }

            }

            if(remaining.size()>0 ){
                System.out.println(recursion(x,y,remaining ));
            }else{
                System.out.println(x ==y);
            }

        }


    }

    private static boolean recursion(int x,int y, Deque<Integer> remaining ){
        if(remaining.size() ==0){
            return x ==y;
        }
        Integer i = remaining.pop();
        boolean recursion = recursion(x + i, y, remaining);
        if(recursion) return true;
        remaining.push(i);
        i = remaining.pop();
        boolean recursion1 = recursion(x, y + i, remaining);
        if(!recursion1) remaining.push(i);
        return recursion1;
    }
}



