package 双循环;

public class leetcode_multiply_43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0") ) return "0";
        if(num1.equals("1") || num2.equals("1") ){
            return num1.equals("1") ? num2 : num1;
        }
        int m = num1.length();
        int n = num2.length();
        //num1和num2最大长度为m+n 因此创建数据长度为m+n用于存储乘积
        //num1[i]×num2[j] 的结果位于 res[i+j+1]
        //如果[i+j+1]≥10，则将进位部分加到 res[i+j]。
        int[] res = new int[ m + n ];
        for (int i = num1.length() -1; i >=0; i--) {
            int n1 = num1.charAt(i) - '0';
            for(int j = num2.length() -1; j>= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int sum = res[i+j+1] + n1 * n2;
                res[i+j+1] = sum  % 10;
                res[i+j] += sum / 10;
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if(i ==0 && res[i] ==0) continue;
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }
}
