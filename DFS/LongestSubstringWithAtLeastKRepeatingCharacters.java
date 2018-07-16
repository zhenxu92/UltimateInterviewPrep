// #395 Longest Substring with At Least K Repeating Characters
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String args[]) {
        String s = "aabaacccabdceea";
        int k = 3;
        System.out.println(longestSubstring(s, 3));
    }

    public static int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        boolean allRepeatingKTimes = true;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                allRepeatingKTimes = false;
                break;
            }
        }
        if (allRepeatingKTimes) return s.length();
        //System.out.println(idx);
        int max = Integer.MIN_VALUE;
        int start = 0;
        int cur = 0;
        while (cur < s.length()) {
            if (freq[s.charAt(cur) - 'a'] < k) {
                max = Math.max(longestSubstring(s.substring(start, cur), k), max);           
                start = cur + 1;
            }
            cur++;
        }
        max = Math.max(max, longestSubstring(s.substring(start, s.length()), k));
        return max;
    }
}