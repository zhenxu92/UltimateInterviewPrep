// Given two different strings, assuming there is only one char more than the other
// This program identifies this letter.

// Use LetterInventory
import java.util.*;
public class FindTheDifference {
    public static void main (String args[]) {
        String s = "abcd";
        String t = "abcdef";
        char diff = findTheDifference(s, t);
        System.out.println(diff);
    }
    
    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                int amount = map.get(s.charAt(i));
                amount++;
                map.put(s.charAt(i), amount);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.keySet().contains(t.charAt(i))) {
                int amount = map.get(t.charAt(i));
                amount++;
                map.put(t.charAt(i), amount);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        String ans = "";
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                //System.out.println(c);
                ans += c;
            }
        }

        return ans.charAt(0);
    }
}