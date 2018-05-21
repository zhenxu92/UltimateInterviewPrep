import java.util.*;
public class ShortestPalindrome {
    public static void main(String args[]) {
        String s = "abcd";
        System.out.println(shortestPalindrome(s));
    }
    public static String shortestPalindrome(String s) {
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
}