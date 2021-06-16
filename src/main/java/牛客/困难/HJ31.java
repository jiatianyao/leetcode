package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] split = str.split("[^A-Za-z]");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length-1; i>=0; i--) {
            String s = split[i];
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
