package 牛客.中等;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ14_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int i = Integer.parseInt(str1);
            String[] array = new String[i];

            while (i>0){
                array[i-1] =  reader.readLine();
                i--;
            }
            Arrays.stream(array).sorted().forEach(System.out::println);
        }
    }

}
