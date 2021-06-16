package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HJ26 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";


        while((str1 =  reader.readLine()) !=null){
            Map<Integer, List<Character>> res = new TreeMap<>((o1, o2) -> o1-o2);
            int length = str1.length();
            for (int i = 0; i < length; i++) {
                char c = str1.charAt(i);
                if(Character.isLetter(c)){
                    int index = 0;
                    if(Character.isUpperCase(c)){
                        index = c-'A';
                    }else{
                        index = c-'a';
                    }

                    List<Character> characters = res.get(index);
                    if(characters ==null){
                        characters = new ArrayList<>();
                    }
                    characters.add(c);
                    res.put(index,characters);
                }

            }

            StringBuilder sb = new StringBuilder();
            for (List<Character> value : res.values()) {
                for (Character character : value) {
                    sb.append(character);
                }
            }

            String s = sb.toString();
            int j =0;

            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char c = str1.charAt(i);
                if(!Character.isLetter(c)){
                    sb2.append(c);
                }else{
                    sb2.append(s.charAt(j++));

                }
            }
            System.out.println(sb2.toString());
        }
    }
}
