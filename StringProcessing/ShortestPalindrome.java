import java.util.*;
public class ShortestPalindrome {
    public static void main(String args[]) {
        String s = "abcbabcaba";
        System.out.println(shortestPalindromeIII(s));
    }
    public static String shortestPalindromeI(String s) {
        int len = s.length();
        int max = 1;
        for (int i = 0; 2 * (i + 1) <= len; i++) {

            StringBuilder sb1 = new StringBuilder(s.substring(0, i + 1));
            StringBuilder sb2 = new StringBuilder(s.substring(i + 1, 2 * (i + 1))).reverse();
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());            
            if (sb1.toString().equals(sb2.toString())) {
                max = 2 * (i + 1);
            }
            if (2 * (i + 1) + 1 <= len) {
                StringBuilder sb3 = new StringBuilder(s.substring(0, i + 1));
                StringBuilder sb4 = new StringBuilder(s.substring(i + 2, 2 * (i + 1) + 1)).reverse(); 
                if (sb3.toString().equals(sb4.toString())) {
                    System.out.println(sb3.toString());
                    System.out.println(sb4.toString()); 
                    max = 2 * (i + 1) + 1;
                }           
            }

       
        }    
        System.out.println(max);
        StringBuilder sb = new StringBuilder(s.substring(max, len)).reverse();
        String ans = sb.toString() + s;
        return ans;
    }
    private static String shortestPalindromeII(String s) {
        int max = 0;
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            StringBuilder left = new StringBuilder(s.substring(0, i));
            StringBuilder right = new StringBuilder(s.substring(i, i * 2));
            right.reverse();
            if (left.toString().equals(right.toString())) max = i * 2;
            if (i * 2 + 1 <= len) {
                StringBuilder oddRight = new StringBuilder(s.substring(i + 1, i * 2 + 1));
                oddRight.reverse();
                if (left.toString().equals(oddRight.toString())) max = i * 2 + 1;
            }   
        }
        System.out.println(max);
        StringBuilder sb = new StringBuilder(s.substring(max, len)).reverse();
        sb.append(s);
        return sb.toString();
    }
    
    private static String shortestPalindromeIII(String s) {
        int len = s.length();
        int i = 0;
        for (int j = len - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == len) return s;
        StringBuilder remainRev = new StringBuilder(s.substring(i, len));
        remainRev.reverse();
        return remainRev.toString() + shortestPalindromeIII(s.substring(0, i)) + s.substring(i);
    }
}