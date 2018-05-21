import java.util.*;
public class PalindromePartition {
    public static List<List<String>> res = new ArrayList<List<String>>();
    public static void main(String args[]) {
        String input = "aab";
        partition(input);
    }
    
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        backTracking(res, new ArrayList<String>(), s, 0);
        return res;
        
    }
    
    
    public static void backTracking(List<List<String>> res, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backTracking(res, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }    
    }
    
    
    public static boolean isPalindrome(String s, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}