package 牛客.中等;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ99 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Map<Integer, Integer> zishoushu = new HashMap<>();
        Map<Integer, Integer> all = new HashMap<>();
        while ((str = reader.readLine()) != null) {
            int i = Integer.parseInt(str);
            int res=0;
            while(i>=0){
                if(zishoushu.containsKey(i)){
                    res+=zishoushu.get(i);
                    break;
                }
                if(all.containsKey(i)){
                    if(all.get(i) ==1){
                        res++;
                    }
                }else{
                    int pow =(int) Math.pow(i,2);
                    String st = ""+pow;
                    if(st.endsWith(""+i)){
                        res++;
                        all.put(i,1);
                    }else{
                        all.put(i,0);
                    }
                }

                i--;
            }
            System.out.println(res);
            zishoushu.put(Integer.parseInt(str),res);
        }


    }
}
