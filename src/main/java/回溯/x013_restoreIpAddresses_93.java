package 回溯;

import java.util.ArrayList;
import java.util.List;


/**
 * 93. 复原 IP 地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 开始时间 2021年5月9日22:58:45
 * 结束时间 2021年5月9日23:59:50
 */
public class x013_restoreIpAddresses_93 {

    public List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        backtrack(chars,0,1,new StringBuffer());
        return result;
    }

    private void backtrack(char[] chars,int begin,int ipSize,StringBuffer stringBuffer){
        if(begin == chars.length && ipSize == 5){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            result.add(new String(stringBuffer.toString()));
            stringBuffer.append(",");
            return;
        }
        if(begin < chars.length && ipSize == 5){
            return;
        }
        if(begin == chars.length && ipSize != 5){
            return;
        }
        if(begin >= chars.length){
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(begin + i > chars.length) return;
            /*if(ipSize == 4 && chars.length -begin > 3) {
                return;
            }*/
            String s = new String(chars, begin, i);
            if(!isLegal(s)) continue;
            stringBuffer.append(s);
            stringBuffer.append(".");
            if(i==1)
            ipSize++;
            backtrack(chars,begin + i,ipSize,stringBuffer);
            stringBuffer.delete(stringBuffer.length()-i-1,stringBuffer.length());
            if(i==3)
            ipSize--;
        }
    }

    public boolean isLegal(String str){
        if(str.startsWith("0") && str.length() > 1) return false;
        return  Integer.parseInt(str) <= 255;
    }

    public static void main(String[] args) {
        x013_restoreIpAddresses_93 demo = new x013_restoreIpAddresses_93();
        demo.restoreIpAddresses("25525511135");
        for (String s : demo.result) {
            System.out.println(s);
        }
    }
}
