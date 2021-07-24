package 练习;

public class plusOne_66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i >=0; i--) {
            int digit = digits[i];
            if(digit !=9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }
}
