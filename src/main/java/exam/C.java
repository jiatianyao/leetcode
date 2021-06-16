package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//https://blog.csdn.net/weixin_33845477/article/details/93167841?utm_medium=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-2.nonecase&depth_1-utm_source=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-2.nonecase
public class C {

    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) != null) {
            String[] s = str.split(" ");


            int[] arr = new int[s.length];
            int sum = 0;
            for (int i = 0; i < s.length; i++) {
                int n = Integer.parseInt(s[i]);
                arr[i] = n;
                sum+=n;
            }
                boolean flag = false;
            int max2 = 0;
            if(sum % arr[arr.length-1] ==0){
                flag = bianli(new boolean[s.length],arr,sum/arr[arr.length-1],0);
                if(flag){
                    max2 = Math.max(max2,max);
                }
            }

            if(flag){
                System.out.println(max2);
            }else{
                System.out.println("-1");
            }






        }

    }

    private static boolean bianli(boolean[] booleans, int[] arr, int target, int index) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > 0; j--) {
                if(arr[j] == target && !booleans[j]){
                    booleans[j]= true;
                    max++;
                    continue;
                }else if(arr[j] + arr[i] == target && !booleans[i] && !booleans[j]){
                    booleans[j]= true;
                    booleans[i]= true;
                    max++;
                    continue;

                }

            }

        }

        for (boolean flag : booleans) {
            if(!flag){
                return false;
            }
        }
        return true;

    }


}
