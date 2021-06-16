package oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//48740875
public class oj116 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int i = Integer.parseInt(str1);
            if(i==0){
                System.out.println("No durian today.Sad(T T).");
            }else if(i==1){
                System.out.println("I ate a durian today!");
            }else{
                String str = "I ate "+i+" durian today!";
                System.out.println(str);
            }
        }
    }
}
