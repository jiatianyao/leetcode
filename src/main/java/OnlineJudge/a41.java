package OnlineJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a41 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str2 = reader.readLine();
        int n = Integer.parseInt(str);
        int k = Integer.parseInt(str2);
        int res = 0;
        int[] f = new int[n+1];
        f[1] = k;
        f[2] = k * (k-1);
        f[3] = 0;
        f[0] = k * (k-1) * (k-2);
        for(int i=4;i<=n;i++) {
            f[i%3] = f[(i-1) % 3]  * (k -2) + f[(i-2) % 3] *(k-1) ;
        }
        System.out.println(f[n%3]);

    }


}
