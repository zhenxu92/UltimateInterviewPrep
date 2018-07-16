// #5 Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public static int max = 0;
    public static int start = 0;
    
    public static void main(String args[]) {
        String s = "abba";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        for (int i = 0; i < s.length(); i++) {
            judge(s, i, i);
            judge(s, i, i + 1);
        }  
        return s.substring(start, start + max);
    }
    
    private static void judge(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if (max < right - left - 1) {
            max = right - left - 1;
            start = left + 1;
        }
        return;
    }
}