// LeetCode #38 Count and Say
// @author Zhen XU
// This program reads the number, and create nth sequence.
// Detailed specification see leetcode.com

import java.util.*;

public class CountAndSay {
    public static void main (String args[]) {
        int n = 5;
        System.out.println(Solution(n));
    }
    
    public static String Solution (int n) {
        List<String> arr = new ArrayList<String>();
        arr.add("1");
        for (int i = 1; i <= n - 1; i++) {
            arr.add(readNumbers(arr.get(i - 1)));    
        }
        return arr.get(n - 1);    
    }
    
    public static String readNumbers (String str) {
        int count = 1;
        String ans = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;    
            } else {
                ans = ans + count + str.charAt(i);
                count = 1;    
            }
        }
        if (count != 1) {
            ans = ans + count + str.charAt(str.length() - 1);
        } else {
            ans = ans + count + str.charAt(str.length() - 1);
        }
        return ans;  
    }
}