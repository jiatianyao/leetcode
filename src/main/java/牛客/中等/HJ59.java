package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ59 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            char[] chars = str1.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                map.put(aChar,map.getOrDefault(aChar,0)+1);
            }
            boolean flag = true;
            for (Character character : chars) {
                if(map.get(character)==1){
                    flag = false;
                    System.out.println(character);
                    break;
                }
            }
            if(flag){
                System.out.println(-1);
            }
        }
    }

}
