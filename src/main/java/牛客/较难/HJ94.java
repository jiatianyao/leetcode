package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2021年4月18日20:57:07
 * 2021年4月18日21:29:51
 *
 * HJ94题目描述
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 * 输入描述:
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
 *
 * 示例1
 * 输入
 * 4
 * A B C D
 * 8
 * A D E CF A GG A B
 * 输出
 * A : 3
 * B : 1
 * C : 0
 * D : 1
 * Invalid : 3
 */
public class HJ94 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int peopleNum = Integer.parseInt(str1);
            String peoples =   reader.readLine();
            String[] s = peoples.split(" ");
            Map<String,Integer> map = new LinkedHashMap <String,Integer>();//按照插入顺序保存数据
            for (String s1 : s) {
                map.put(s1,0);
            }
            int voteNum = Integer.parseInt(reader.readLine());
            String votes =   reader.readLine();
            String[] s1 = votes.split(" ");
            int error=0;
            for (int i = 0; i < s1.length; i++) {
                String s2 = s1[i];
                if(map.containsKey(s2)){
                    map.put(s2,map.get(s2)+1);
                }else{
                    error++;
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("Invalid : "+error);

        }
    }

}


