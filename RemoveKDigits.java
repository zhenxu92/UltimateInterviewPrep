// 402 RemoveKDigits
// @author ZhenXu

import java.util.*;
public class RemoveKDigits {
    public static void main (String args[]) {
        String num = "1234567890";
        int k = 9;
        String ans = Solution(num, k);
        System.out.println(ans);
    }
    
    public static String Solution (String num, int k) {
        Stack<Character> s = new Stack<Character>();
        Stack<Character> o = new Stack<Character>();
        int count = k;
        for (int i = num.length() - 1; i >= 0; i--) {
            o.push(num.charAt(i));
        } 
        int i = 0;
            while (!o.isEmpty() && k > 0 && i < num.length() - k) {
                s.push(o.pop());  
                i++;  
                if (!o.isEmpty() && s.peek() > o.peek()) {
                    s.pop();
                    // s.push(o.pop());
                    k--;
                }
            }
        
        while (!o.isEmpty() && i < num.length() - k) {
            s.push(o.pop());
        }
        
        
        
//         if (count == k) {
//             while (k > 0) {
//                 s.pop();
//                 k--;
//             }
//             if (s.isEmpty()) {
//             
//             }    
//         }
        if (s.isEmpty()) {
            s.push('0');
        }
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}