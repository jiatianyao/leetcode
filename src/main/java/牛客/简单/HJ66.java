package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//2021年4月11日 00:22:42
//2021年4月11日 01:02:27
//2021年4月11日 01:11:51

/**
 * 题目描述
 * 有6条配置命令，它们执行的结果分别是：
 *
 * 命   令	执   行
 * reset	reset what
 * reset board	board fault
 * board add	where to add
 * board delete	no board at all
 * reboot backplane	impossible
 * backplane abort	install first
 * he he	unknown command
 * 注意：he he不是命令。
 *
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 *
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 */


public class HJ66 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        map.put("reset","reset what");
        map.put("reset board" ,"board fault");
        map.put("board add" ,"where to add");
        map.put("board delete" ,"no board at all");
        map.put("reboot backplane" ,"impossible");
        map.put("backplane abort","install first");

        String str = "";
        while((str = reader.readLine()) !=null){

            if(str.contains(" ")){
                String res ="";
                boolean flag = true;
                String[] split = str.split(" ");
                String key1 = split[0];
                String key2 = split[1];
                for (String s : map.keySet()) {
                    if(!s.contains(" ")) continue;
                    String[] split2 = s.split(" ");
                    String skey1 = split2[0];
                    String skey2 = split2[1];
                        if(skey1.startsWith(key1) && skey2.startsWith(key2) && res.length() >0 ){
                        flag = false;

                    }else if(skey1.startsWith(key1) && skey2.startsWith(key2) && res.length() ==0 ){
                        res = map.get(s);
                    }

                }
                if(res.length() >0 && flag){
                    System.out.println(res);
                }else{
                    System.out.println("unknown command");
                }
            }else{
                String res ="";
                boolean flag = true;
                for (String s : map.keySet()) {
                    if(s.contains(" ")) continue;
                   if(s.startsWith(str) && res.length() >0 ){
                       flag = false;

                   }else if(s.startsWith(str) && res.length() ==0 ){
                       res = map.get(s);
                   }
                }
                if(res.length() >0 && flag){
                    System.out.println(res);
                }else{
                    System.out.println("unknown command");
                }
            }
        }
    }
}


