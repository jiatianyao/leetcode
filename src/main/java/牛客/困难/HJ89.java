package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2021年4月21日21:11:48
 * 2021年4月21日23:36:50
 *
 * 题目描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，
 * 本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 *
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 *
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 *
 * 详细说明：
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过+-*四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2 A 9 A不能变为(2+1)*(9-1)=24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 * 7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，除数(即分母)的数字不可能为0
 */
public class HJ89 {
    public static Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("A", 1);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
        }
    };


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");
            boolean flag = false;
            for (int i = 0; i < s.length; i++) {
                String s1 = s[i];
                if(s1.equals("joker") || s1.equals("JOKER") ){
                    flag= true;
                }
            }
            if(flag){
                System.out.println("ERROR");
            }else{
                boolean used[] = new boolean[4];
                flag = true;
                for (int i = 0; i < 4; i++) {
                    used[i] =true;
                    boolean dfs = dfs(map.get(s[i]), s, 0, s[i], used);
                    if(dfs){
                        flag = false;
                        break;
                    }else{
                        used[i] =false;
                    }

                }

                if(flag){
                    System.out.println("NONE");
                }
            }

        }
    }

    private static boolean dfs(int sum, String[] s, int index, String res , boolean [] used){
        if(index >= 3 ){
            if(sum == 24){
                System.out.println(res);
            }
            return sum == 24;
        }
        for (int i = 0; i < 4; i++) {
            if(used[i]){
                continue;
            }else{
                String s1 = s[i];
                Integer num = map.get(s1);
                used[i] = true;
                if(dfs(sum+num,s,index+1,res+"+"+s1,used)){
                    return true;
                }
                if( dfs(sum-num,s,index+1,res+"-"+s1,used)){
                    return true;
                }
                if( dfs(sum*num,s,index+1,res+"*"+s1,used)){
                    return true;
                }
                if(sum % num ==0) {
                    if (dfs(sum / num, s, index + 1, res + "/" + s1, used)) {
                        return true;
                    }
                }
                used[i] = false;
            }

        }

        return false;

    }
}
