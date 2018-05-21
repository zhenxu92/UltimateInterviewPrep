import java.util.*;
public class CalculatorII {
    public static void main(String args[]) {
        String s  = "3 + 2 * 2";
        calculate(s);
    }
    public static int calculate(String s) {
        // sc
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}