package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class k003_Codec_535_2 {

    String chars = "qazwsxedcrfvtgbyhnujmikolp1234567890QAZWSXEDCRFVTGBYHNUJMIKOLP";
    int count = 1;
    HashMap<String,String> map = new HashMap<>();

    public String getString(){
        int c = count;
        StringBuffer sb = new StringBuffer();
        while(c>0){
            c--;
            sb.append(chars.charAt(c%62));
            c/=62;
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getString();
        map.put(key,longUrl);
        count++;
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/",""));
    }
}
