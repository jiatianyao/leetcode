package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 */
public class HJ36 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String key;
        while ((key = bf.readLine()) != null) {
            String data = bf.readLine();
            System.out.println(getValue(key,data));
        }
    }
    private static String getValue(String key, String data) {
        StringBuilder sb = new StringBuilder();
        key = key.toLowerCase();//都转成小写
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!list.contains(c)) list.add(c);
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if (!list.contains(c)) list.add(c);
        }
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isLetter(c)){//之前需要加密的密文当成一个单词没有注意排除空格，醉了....
                boolean flag = Character.isLowerCase(c);//记录是否是小写字母
                c = list.get(Character.toLowerCase(c) - 'a');//list中存储的都是小写字母
                sb.append(flag ? c : Character.toUpperCase(c));
            }else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
