package 牛客.中等;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HJ14 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int i = Integer.parseInt(str1);
            List<String> list = new ArrayList<>();

            while (i>0){
                list.add(reader.readLine());
                i--;
            }
            list.sort((o1, o2) -> o1.compareTo(o2));
            list.forEach(a-> System.out.println(a));
        }
    }

}
