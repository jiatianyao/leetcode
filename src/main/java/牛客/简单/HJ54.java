package 牛客.简单;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class HJ54 {

    static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int num = 0;
        int length = s.length();
        boolean flag = false;

        //消除（）
        Deque<Character> stack1 = new LinkedList<>();
        while(s.contains("(") && s.contains(")")){
            String left = "";
            String middle ="";
            String right ="";

            for (int i = 0; i < s.length(); i++) {
                stack1.push(s.charAt(i));
            }

            while(!stack1.isEmpty()){
                if(stack1.peek() == '(' && middle.equals("")){
                    stack1.pop();
                    middle = right;
                }else if(!middle.equals("")){
                    left = stack1.pop() + left;
                }else{
                    right = stack1.pop() + right;
                }
            }
            right =  middle.substring(middle.indexOf(")")+1,middle.length());
            middle = middle.substring(0,middle.indexOf(")"));
            s = left + calNum(middle) + right;
        }

        while(s.contains("[") && s.contains("]")){
            String left = "";
            String middle ="";
            String right ="";

            for (int i = 0; i < s.length(); i++) {
                stack1.push(s.charAt(i));
            }

            while(!stack1.isEmpty()){
                if(stack1.peek() == '[' && middle.equals("")){
                    stack1.pop();
                    middle = right;
                }else if(!middle.equals("")){
                    left = stack1.pop() + left;
                }else{
                    right = stack1.pop() + right;
                }
            }
            right =  middle.substring(middle.indexOf("]")+1,middle.length());
            middle = middle.substring(0,middle.indexOf("]"));
            s = left + calNum(middle) + right;
        }

        while(s.contains("{") && s.contains("}")){
            String left = "";
            String middle ="";
            String right ="";

            for (int i = 0; i < s.length(); i++) {
                stack1.push(s.charAt(i));
            }

            while(!stack1.isEmpty()){
                if(stack1.peek() == '[' && middle.equals("")){
                    stack1.pop();
                    middle = right;
                }else if(!middle.equals("")){
                    left = stack1.pop() + left;
                }else{
                    right = stack1.pop() + right;
                }
            }
            right =  middle.substring(middle.indexOf("}")+1,middle.length());
            middle = middle.substring(0,middle.indexOf("}"));
            s = left + calNum(middle) + right;
        }

        int res = calNum(s);
        if(flag) System.out.println("");
        System.out.println(res);
    }


    public static int calNum(String middle){
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char pre = '+';
        int length = middle.length();
        boolean isLianXuFuHao = false;
        for (int i = 0; i < length; i++) {
            char c = middle.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            }
            if(num == 0 && (pre == '*' || pre =='/') && c =='-' && i>1){
                isLianXuFuHao = true;
                continue;
            }
            if(flag) break;
            if (!Character.isDigit(c) && c != ' ' || i == length -1){
                switch (pre){
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        if(isLianXuFuHao) {
                            stack.push(stack.pop() * -num);
                            isLianXuFuHao = false;
                        }else{
                            stack.push(stack.pop() * num);
                        }
                        break;
                    case '/' :
                        if(isLianXuFuHao) {
                            stack.push(stack.pop() / -num);
                            isLianXuFuHao = false;
                        }else{
                            stack.push(stack.pop() / num);
                        }

                        break;
                    default:
                        flag=true;
                        break;
                }
                pre = c;
                num = 0;
            }

        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
