package 牛客.中等;

import java.util.Scanner;

public class HJ99_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int selfHoldNumber = 0;
            for (int i = 0; i <= n; i++) {
                if (((int) Math.pow(i, 2) + "").matches("[0-9]*" + i + "$")) {
                    selfHoldNumber++;
                }
            }
            System.out.println(selfHoldNumber);
        }
    }
}
