package 哈希表;

import java.util.HashMap;
import java.util.Random;

public class k003_Codec_535_4 {
    String chars = "qazwsxedcrfvtgbyhnujmikolp1234567890QAZWSXEDCRFVTGBYHNUJMIKOLP";
    HashMap<String, String> map = new HashMap<>();
    Random r = new Random();//随机数
    String key = getRand();

    private String getRand() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(chars.charAt(r.nextInt(62)));

        }
        return stringBuffer.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(map.containsKey(key)){
            key = getRand();
        }
        map.put(key,longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/",""));
    }
}
