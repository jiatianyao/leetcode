package 牛客.入门;

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextFloat()){
            double d = in.nextDouble();
            int dint = (int)d;
            if((d-dint)>=0.5 && (d-dint)<1)
                dint++;
            System.out.println(dint);

        }
    }
}
