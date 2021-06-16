package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class x011_letterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(result, phoneMap, digits, 0, new StringBuffer());
        return result;

    }

    private void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {
        if(index == digits.length()){
            result.add(stringBuffer.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = phoneMap.get(c);
        int length = s.length();
        for (int j = 0; j < length; j++) {
            stringBuffer.append(s.charAt(j));
            backtrack(result, phoneMap, digits, index+1, stringBuffer);
            stringBuffer.deleteCharAt(index);
        }


    }
}
