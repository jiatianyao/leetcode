package 牛客.较难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ24 {
    public static Integer minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int size = Integer.parseInt(str1);
            String str2 = reader.readLine().trim();
            String[] s = str2.split(" ");
            minNum = Integer.MAX_VALUE;

            System.out.println(dp(s,0,0,0));
        }
    }

    public static int dp(String[] s,int index,int removeNum,int lastValue){
        if(index >= s.length-1){
            if (removeNum<minNum){
                minNum = removeNum;
            }
            return minNum;
        }

        if(removeNum > minNum) return minNum;


        int n = Integer.parseInt(s[index]);
        if(n>lastValue) {
            int i = index + 1;
            int removeN = removeNum +1;
            return Math.min(dp(s, i, removeNum, n), dp(s, i, removeN, lastValue));
        }else{
            //remove当前节点
            index = index +1;
            removeNum = removeNum +1;
            return dp(s, index, removeNum, lastValue);
        }



    }

}
