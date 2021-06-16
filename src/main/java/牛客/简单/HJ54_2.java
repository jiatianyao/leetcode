package 牛客.简单;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * HJ54 表达式求值
 * 题目描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，
 * 字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 *
 * 输入描述:
 * 输入算术表达式
 *
 * 输出描述:
 * 计算出结果值
 *
 * 示例1
 * 输入
 * 400+5
 * 输出
 * 405
 */
public class HJ54_2 {

    public static void main(String[] args) throws ScriptException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String pattern = "[^\\d|()*+-/]";
        if (!Pattern.compile(pattern).matcher(str).find()) {

            ScriptEngineManager em = new ScriptEngineManager();
            ScriptEngine javaScript = em.getEngineByName("JavaScript");
            System.out.println(javaScript.eval(str));
        }else{
            System.out.println(-1);
        }
    }
}


