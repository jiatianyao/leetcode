package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ95人民币转换
 * 2021年4月18日21:31:52
 * 2021年4月18日22:30:49
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、
 *      捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成
 *              “人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，
 *      中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 */
public class HJ95_biantai {

    private static String[] translate = {
            "零", "壹", "贰", "叁",
            "肆", "伍", "陆", "柒",
            "捌", "玖"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] s = str1.split("\\.");
            String right = "";
            String left = "人民币";

            long x = Long.parseLong(s[0]);
            long x1 = x / 100000000;
            if(x1 >0){
                left+= translate[(int)x1] +"亿";
                x = x - x1*100000000;
            }
            long x2 = x / 10000;
            if(x2 >0){
                String str = chuli((int)x2,left);
                left+= str +"万";
                x = x - x2 * 10000;
            }

            String str = chuli((int)x,left);
            left+= str;
            left = left.replace("零零","零");//放在外面替换少循环几次

            if(s[1].equals("00")){
                right = "元整";
            }else{
                if(left.length() > 3) {
                    right += "元";
                }
                char c = s[1].charAt(0);
                if(Integer.parseInt(String.valueOf(c)) !=0) {
                    right += translate[Integer.parseInt(String.valueOf(c))] + "角";
                }

                char d = s[1].charAt(1);
                if(Integer.parseInt(String.valueOf(d)) !=0){
                    right+=translate[Integer.parseInt(String.valueOf(d))] +"分";
                }
            }
            String res = left+right;
            System.out.println(res);
        }
    }

    private static String chuli(int x,String left) {
        String res = "";
        int x1 = x /1000;
        if(x1>0){
            res += translate[x1]+"仟";
            x = x - x1 * 1000;
        }else if(left.length() >3){
            res += "零";
        }
        int x2 = x/100;
        if(x2>0){
            res += translate[x2]+"佰";
            x = x - x2 * 100;
        }else if(left.length() >3 || x1 >0){
            res += "零";
        }
        int x3 = x/10;
        if(x3>0){
            if(x3==1){
                res += "拾";
            }else {
                res += translate[x3] + "拾";
            }
            x = x - x3 * 10;
        }else if(left.length() >3 || x1 > 0 || x2 >0){
            res += "零";
        }
        if(x>0)
        res += translate[x];
        if(res.endsWith("零零")){
           return res.substring(0,2);
        }
        return res;
    }
}
