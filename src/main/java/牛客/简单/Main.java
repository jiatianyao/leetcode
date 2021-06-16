package 牛客.简单;

import java.util.Scanner;

public class Main
{
    public String GetPwdSecurityLevel(String pPasswordStr)
    {
        int score = 0;

        boolean number = false;
        boolean upper = false;
        boolean lower = false;
        boolean symbol = false;
        boolean numberOnce = true;
        boolean symbolOnce = true;

        if (pPasswordStr.length() <= 4) {
            score += 5;
        }

        else if (pPasswordStr.length() <= 7) {
            score += 10;
        }
        else {
            score += 25;
        }

        for (char ch : pPasswordStr.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                if (number && numberOnce) {
                    score += 20;
                    numberOnce = false;
                }
                number = true;
            }
            else if (ch >= 'a' && ch <= 'z') {
                lower = true;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                upper = true;
            }
            else if (
                    ch >= 0x21 && ch <= 0x2F ||
                            ch >= 0x3A && ch <= 0x40 ||
                            ch >= 0x5B && ch <= 0x60 ||
                            ch >= 0x7B && ch <= 0x7E)
            {
                if (symbol && symbolOnce) {
                    score += 25;
                    symbolOnce = false;
                }
                symbol = true;
            }

        }

        if (number && numberOnce) {
            score += 10;
        }
        if (symbol && symbolOnce) {
            score += 10;
        }
        if (lower && upper) {
            score += 20;
        }
        else if (lower || upper) {
            score += 10;
        }
        if (lower && upper && number && symbol) {
            score += 5;
        }
        else if ((lower || upper) && number && symbol) {
            score += 3;
        }
        else if ((lower || upper) && number) {
            score += 2;
        }

        if (score >= 90) {
            return "VERY_SECURE";
        }
        else if (score >= 80) {
            return "SECURE";
        }
        else if (score >= 70) {
            return "VERY_STRONG";
        }
        else if (score >= 60) {
            return "STRONG";
        }
        else if (score >= 50) {
            return "AVERAGE";
        }
        else if (score >= 25) {
            return "WEAK";
        }
        else {
            return "VERY_WEAK";
        }
    }

    public Main()
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
        {
            String pPasswordStr = in.nextLine();
            String safelevel = GetPwdSecurityLevel(pPasswordStr);
            System.out.println(safelevel);
        }
    }

    public static void main(String[] args)
    {
        Main solution = new Main();
    }
}
