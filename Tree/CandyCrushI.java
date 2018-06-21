import java.util.*;
public class CandyCrushI {
    public static void main(String args[]) {
        String s = "AAWWWWASAFF";
        System.out.println(candyCrush(s));
    }
    
    public static String candyCrush(String s) {
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            int j = i;
            while (j < s.length() && s.charAt(j) == c) {
                count++;
                j++;
            }
            if (count >= 3) {
                i = j;
                continue;
            // can't be cancelled directly
            } else {
                if (!stack.isEmpty()) {
                    int[] pair = stack.peek();
                    if (c == pair[0]) {
                        if (pair[1] + count >= 3) {
                            stack.pop();
                        } else {
                            stack.pop();
                            stack.push(new int[]{c, pair[1] + count});
                        }
                    } else {
                        stack.push(new int[]{c, count});
                    }      
                } else {
                    stack.push(new int[]{c, count});
                }
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            for (int k = 0; k < pair[1]; k++) {
                sb.append((char)pair[0]);
            }
        }
        return sb.reverse().toString();
    }
}