package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class HJ19 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split(" ");

            String str = s[0].substring(s[0].lastIndexOf("\\")+1);
            if(str.length()>16){
                str = str.substring(str.length()-16);
            }
            String res = str+" "+s[1];
            if(map.containsKey(res)){
                map.put(res,map.get(res)+1);
            }else{
                map.put(res,1);
            }
        }
        int x = map.size()-8;
        int  i =1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(i>x){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
            i++;

        }
    }
}
