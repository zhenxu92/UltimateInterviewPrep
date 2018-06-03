import java.util.*;
public class BackspaceStringCompare {
    public static void main(String args[]) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(process(s.toCharArray()));
    }
    public static boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        String S1 = process(s);
        String T1 = process(t);
        return S1.equals(T1);
    }
    
    private static String process(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '#') {
                if (stack.isEmpty()) continue;
                else stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}