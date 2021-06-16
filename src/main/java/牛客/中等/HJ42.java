package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年4月18日09:32:51
 * 2021年4月18日10:42:01
 */
public class HJ42 {

    public static String[] num1 = {"zero", "one", "two", "three", "four"
            , "five", "six", "seven", "eight", "nine"};
    public static String[] num2 = {"ten","eleven","twelve","thirteen","fourteen"
            ,"fifteen","sixteen","seventeen","eighteen","nighteen"};
    public static String[] num3 = {"twenty","thirty","forty","fifty"
            ,"sixty","seventy","eighty","ninety"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            long l = Long.parseLong(str1);
            String str = "";
            if(String.valueOf(l).length()==9) {
                long l1 = l / 100000000;
                if (l1 != 0) {
                    str += num1[(int) l1] + " billion ";
                    l = Long.parseLong(str1.substring(1));
                }
            }
            if(String.valueOf(l).length()>6) {
                long l2 = l / 1000000;
                if (l2 != 0) {
                    if (l % 1000000 == 0) {
                        str += num1[(int) l2 + 1] + " million ";
                    } else {
                        str += printNum(l2) + " million ";
                    }

                    l = l - l2 * 1000000;
                }
            }
            if(String.valueOf(l).length()>3) {
                long l3 = l / 1000;

                if (l3 != 0) {
                    if (l % 1000 == 0) {
                        str += num1[(int) l3 + 1] + " thousand ";
                    } else {
                        str += printNum(l3) + " thousand ";
                    }

                    l = l - l3 * 1000;
                }
            }
            if((int) l>0){
                str += " "+printNum(l);
            }
            str = str.replace("  "," ");
            System.out.println(str.trim());


        }
//        System.out.println(printNum(101));

    }

    private static String printNum(long n){
        String res = "";
        long x = n/100;

        if(x !=0){
            n = n-x*100;
            if(n%x ==0 && (int)n >= 100){
                res += num1[(int) x] + " hundred";
            }else {
                res += num1[(int) x] + " hundred and";
            }
        }

        long y = n/10;
        if(y>1){

            res +=" "+num3[(int)y-2];
            n = n -y*10;
        }

        if(n==0)return res.trim();
        if(y==1){
            n = n -y*10;
            res +=" "+num2[(int)n];
        }else{
            res +=" "+num1[(int)n];
        }

        return res.trim();
    }

}
