package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 2021年4月16日22:54:57
 * 2021年4月16日23:57:26
 */
public class HJ25 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String str2 =  reader.readLine();
            String[] s1 = str1.split(" ");
            String[] s2 = str2.split(" ");
            int len1 = Integer.parseInt(s1[0]);
            int len2 = Integer.parseInt(s2[0]);
            int[] I =  new int[len1];
            int[] R =  new int[len2];
            for (int i = 1; i < s1.length; i++) {
                I[i-1] = Integer.parseInt(s1[i]);
            }
            for (int i = 1; i < s2.length; i++) {
                R[i-1] = Integer.parseInt(s2[i]);
            }
            Arrays.sort(R);


            StringBuffer result = new StringBuffer();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < R.length; i++) {

                int m = R[i];
                int count =0;
                StringBuffer sb = new StringBuffer();
                if (set.contains(m)) {
                    continue;
                }else{
                    set.add(m);
                }
                for (int j = 0; j < I.length; j++) {
                    int n = I[j];
                    if((""+n).contains(""+m)){
                        count++;
                            sb.append(j);
                            sb.append(" ");
                            sb.append(n);
                            sb.append(" ");

                    }

                }
                if(count>0){
                    result.append(m);
                    result.append(" ");
                    result.append(count);
                    result.append(" ");
                    result.append(sb.toString());
                }


            }

            String[] split = (result + "").split(" ");
            System.out.println(split.length+" "+result);

        }
    }
}
