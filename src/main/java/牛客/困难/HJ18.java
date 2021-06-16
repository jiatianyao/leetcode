package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 第一次
 * 2021年4月18日23:55:44
 * 2021年4月19日01:00:46
 * 优化
 * 2021年4月19日21:25:14
 * 2021年4月19日22:03:42
 */
public class HJ18 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int error = 0;
        int pri =0;
        while((str1 =  reader.readLine()) !=null){
            String[] split = str1.split("~");
            String ip = split[0];
            String mark = split[1];
            String[] marks = mark.split("\\.");
            String[] ips = ip.split("\\.");
            boolean isError = false;
            //判断IP是否合法
            if((ips[0] ==null || Integer.parseInt(ips[0]) > 255) ||
                    (ips[1] ==null || Integer.parseInt(ips[1]) > 255 )||
                    (ips[2] ==null || Integer.parseInt(ips[2]) > 255 )||
                    (ips[3] ==null || Integer.parseInt(ips[3]) > 255 )
            ){
                error++;
                continue;
            }

            // 判断掩码是否错误
            if (!validMaskCode(mark)) {
                error++;
                continue;
            }

            if(Integer.parseInt(ips[0]) >= 1 && Integer.parseInt(ips[0])<=126 ){
//                System.out.println(ip+"~"+mark);
                A++;
            }else  if(Integer.parseInt(ips[0]) >= 128 && Integer.parseInt(ips[0])<=191 ){
                B++;
            }else  if(Integer.parseInt(ips[0]) >= 192 && Integer.parseInt(ips[0])<=223 ){
                C++;
            }else  if(Integer.parseInt(ips[0]) >= 224 && Integer.parseInt(ips[0])<=239 ){
                D++;
            }else  if(Integer.parseInt(ips[0]) >= 240 && Integer.parseInt(ips[0])<255 ){
                E++;
            }
            if(Integer.parseInt(ips[0]) ==10){
                pri++;
            }else   if(Integer.parseInt(ips[0]) ==172  && Integer.parseInt(ips[1])>=16   && Integer.parseInt(ips[1])<=31 ){
                pri++;
            }else   if(Integer.parseInt(ips[0]) ==192  && Integer.parseInt(ips[1])== 168 ){
                pri++;
            }else{
//                System.out.println(ip);
            }

        }

        System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+error+" "+pri);
    }

    /**
     * 判断掩码是否是前面全为1后面全为0 的格式
     *
     * @param maskCode
     * @return
     */
    private static boolean validMaskCode(String maskCode) {
        boolean res = true;
        String[] nums = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int firstIndexOf0 = sb.indexOf("0");
        int lastIndexOf1 = sb.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            res = false;
        }
        return res;
    }

    /**
     * 将整数转成对应的八位二进制字符串
     * @param num
     * @return
     */
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }

}
