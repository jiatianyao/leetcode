package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) != null) {
            str = String.join("", str.split(" ")); // 合并字符串
            str = handlerStr(str);
            System.out.println(solution(str));
        }

        reader.close();
    }

    public static String solution(String str){
        if (null == str || str.length() == 0) return str;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // 对16进制的字符处理
            if (String.valueOf(str.charAt(i)).matches("[0-9A-Fa-f]")){
                char c = str.charAt(i);
                int dec = Integer.parseInt(String.valueOf(c), 16);
                dec = reverseBit(dec);
                builder.append(Integer.toHexString(dec).toUpperCase());
                continue;
            }
            // 其他字符直接拼接
            builder.append(str.charAt(i));
        }

        return builder.toString();
    }

    /**
     * bit反转，分治法
     * @param n
     * @return
     */
    public static int reverseBit(int n){
        n = ((n & 0xc) >>> 2) | ((n & 0x3) << 2);
        n = ((n & 0xa) >>> 1) | ((n & 0x5) << 1);
        return n;
    }

    /**
     * 字符串奇偶排序
     * @param str
     * @return
     */
    public static String handlerStr(String str){
        if (null == str || str.length() == 0) return str;
        List<Character> even = new ArrayList<>();
        List<Character> odd = new ArrayList<>();
        // 找出偶数下标组和奇数下标组
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) even.add(str.charAt(i));
            else odd.add(str.charAt(i));
        }
        // 排序
        even = even.stream().sorted(Character::compareTo).collect(Collectors.toList());
        odd = odd.stream().sorted(Character::compareTo).collect(Collectors.toList());
        // 排序后再按原下标位置合并起来
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < even.size(); i++) {
            builder.append(even.get(i));
            if (i < odd.size()) builder.append(odd.get(i));
        }
        return builder.toString();
    }
}
