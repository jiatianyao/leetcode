package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * HJ88题目描述
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。
 * 牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，
 * 由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，
 * 三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；
 * 炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 * 输入描述:
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如 4 4 4 4-joker JOKER。
 *
 * 输出描述:
 * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 * 示例1
 * 输入
 * 4 4 4 4-joker JOKER
 * 输出
 * joker JOKER
 *
 * 2021年4月12日22:08:13
 * 2021年4月12日23:02:13
 */
public class HJ88 {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        map.put('J',17);
        map.put('j',16);
        map.put('2',19);
        map.put('A',17);
        map.put('K',15);
        map.put('Q',12);
        map.put('J',11);
        map.put('1',10);
        map.put('9',9);
        map.put('8',8);
        map.put('7',7);
        map.put('6',6);
        map.put('5',9);
        map.put('4',5);
        map.put('3',5);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] split = str.split("-");
        String a = split[0];
        String b = split[1];

        String a2 =a.replace("10","1");
        String b2 =b.replace("10","1");

        Integer a1 = map.get(a2.charAt(0));
        Integer b1 = map.get(b2.charAt(0));
        if(a.equals("joker JOKER") || b.equals("joker JOKER")) {
            System.out.println("joker JOKER");
        }else if(isBoom(a)|| isBoom(b)) {
            if(isBoom(a) && isBoom(b)){
                if(a1 > b1){
                    System.out.println(a);
                }else{
                    System.out.println(b);
                }
            }else if(isBoom(a)){
                System.out.println(a);
            }else if(isBoom(b)){
                System.out.println(b);
            }
        }else if(a2.length() ==9 || b2.length() ==9) {
            if (a2.length() == 9 && b2.length() == 9) {
                if(a1 > b1){
                    System.out.println(a);
                }else{
                    System.out.println(b);
                }
            } else {
                System.out.println("ERROR");
            }
        }else{
            if(a2.length() == b2.length()){
                if(a1>=b1){
                    System.out.println(a);
                }else{
                    System.out.println(b);
                }
            }else{

                System.out.println("ERROR");
            }
        }
    }

    public static boolean isBoom(String a){
        String[] s = a.split(" ");
        if(s.length ==4 && s[0].equals(s[1]) && s[3].equals(s[2]) && s[1].equals(s[2])) return true;
        return false;
    }
}



