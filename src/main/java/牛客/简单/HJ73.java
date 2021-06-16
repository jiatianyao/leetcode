package 牛客.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 根据输入的日期，计算是这一年的第几天。。
 *
 * 测试用例有多组，注意循环输入
 * 输入描述:
 * 输入多行，每行空格分割，分别是年，月，日
 *
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 * 失败:返回-1
 * 2021年4月11日 01:35:30
 */
public class HJ73 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Map<String,Integer> map = new HashMap<>();
        map.put("1",31);
        map.put("2",28);
        map.put("3",31);
        map.put("4",30);
        map.put("5",31);
        map.put("6",30);
        map.put("7",31);
        map.put("8",31);
        map.put("9",30);
        map.put("10",31);
        map.put("11",30);
        map.put("12",31);
        while((str = reader.readLine()) !=null){
            String[] s = str.split(" ");
            String year = s[0];
            String month = s[1];
            String day = s[2];
            int yearI = Integer.parseInt(year);
            int mongthI = Integer.parseInt(month);
            int dayI = Integer.parseInt(day);
            if(mongthI > 2 && ((yearI % 4 ==0 && yearI % 100 !=0 ) || yearI % 400 ==0) ){
                map.put("2",29);
            }
            if(map.get(month) < dayI || yearI >9999 || mongthI>12) System.out.println(-1);
            int res = 0;
            while(mongthI-1 >0){
                res+= map.get((mongthI - 1)+"");
                mongthI--;
            }
            res+=dayI;
            System.out.println(res);

            map.put("2",28);
        }
    }
}

