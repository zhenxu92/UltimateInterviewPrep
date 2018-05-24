import java.util.*;
public class SmallestStringOfAllCharacter {
    public static Map<Character, Integer> map = new HashMap<>();
    public static String res = "";
    public static int min = Integer.MAX_VALUE;
    public static void main(String args[]) {
        char[] arr = new char[]{'A', 'B', 'C', 'E', 'K', 'I'};
        String s = "KADOBECODEBANCDDDEI";
        String ans = smallestSubstring(arr, s);
        System.out.println(ans);
    }
    
    private static String smallestSubstring(char[] arr, String s) {
        if (arr == null || arr.length == 0) return "";
        if (s == null || s.length() == 0) return "";
        int head = 0;
        int tail = 0;
        for (char c : arr) {
            map.put(c, 0);
        }    
        int count = 0;
        while (tail < s.length() || head < s.length()) {
            // loseChar
            if (count == arr.length) {
                if (tail - head < min) {
                    min = tail - head + 1;
                    res = s.substring(head, tail);
                }
                char chead = s.charAt(head);
                if (map.containsKey(chead)) {
                    int freq = map.get(chead);
                    if (freq - 1 == 0) {
                        count--;
                    }
                    map.put(chead, freq - 1);
                }
                head++;
            } else {
                if (tail >= s.length()) break;
                // not every character are in
                // gainChar
                // add current char
                char ctail = s.charAt(tail);
                // only gainChar if it is in
                if (map.containsKey(ctail)) {
                    int freq = map.get(ctail);
                    if (freq == 0) {   
                        count++;
                    }
                    map.put(ctail, freq + 1);
                }
                // increment
                
                tail++;
            }
        }
        return res;
    }
}