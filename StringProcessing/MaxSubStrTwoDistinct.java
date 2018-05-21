import java.util.*;
public class MaxSubStrTwoDistinct {
    public static void main(String args[]) {
        String s = "eceba";
        lengthOfLongestSubstringTwoDistinct(s);
        
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        // Sanity check
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int lo = 0, hi = 0, maxlen = 0;
        while (hi < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(hi), hi);
                hi++;
            }
            // you must determine if it is larger than 2 every time
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int i : map.values()) {
                    leftMost = Math.min(i, leftMost);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                lo = leftMost + 1;
            }
            maxlen = Math.max(maxlen, hi - lo);
        }
        return maxlen;
    }

}