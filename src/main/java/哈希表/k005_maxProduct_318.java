package 哈希表;

public class k005_maxProduct_318 {
    public int maxProduct(String[] words) {
        int[] mark = new int[words.length];
        for (int i=0;i<words.length;i++){
            for (char c : words[i].toCharArray()){
                mark[i] |= 1 << (c -'a');
            }
        }
        int ans = 0;
        for (int i = 0;i<words.length;i++){
            for (int j = i +1;j<words.length;j++) {
                if((mark[i] & mark[j] ) !=0) continue;
                ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
