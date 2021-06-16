package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ60 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){

            int n = Integer.parseInt(str1);
            for (int j = n/2; j >1; j--) {
                if(isPrime(j)&&isPrime(n-j)){
                    System.out.println(j);
                    System.out.println(n-j);
                    break;
                }

            }
        }
    }

    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
             }
        }
        return true;
    }
}
