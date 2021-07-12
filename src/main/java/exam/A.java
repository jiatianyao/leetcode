package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine())!=null){
            String[] s = str.split(" ");
            int peopleNum = s.length;
            int[] arr = new int[peopleNum];
            int timeSum = 0;
            for (int i = 0; i < peopleNum; i++) {
                int times = Integer.parseInt(s[i]);
                if(times!=0){
                    timeSum+= times;
                }
            }
            int time2 = 0;
            int n = 1;
            while(time2< timeSum){
                if(isHasSeven(n)){
                    time2++;
                    int x = n%peopleNum-1;
                    if(x<0){
                        arr[peopleNum-1]++;
                    }else{
                        arr[x]++;
                    }

                }
                n++;
            }

            for (int i = 0; i < peopleNum; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isHasSeven(int n) {
        if((""+n).contains("7") || n % 7 ==0){
            return true;
        }
        return false;
    }


}
