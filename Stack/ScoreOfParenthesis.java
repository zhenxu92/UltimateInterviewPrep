import java.util.*;
public class ScoreOfParenthesis {
    public static void main(String args[]) {
        String s = "(()())";
        System.out.println(scoreOfParentheses(s));
    }
    
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        stack.push(0);
        for (char c : arr) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}