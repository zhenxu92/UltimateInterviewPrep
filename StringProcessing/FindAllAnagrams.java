// Leetcode #438 Finding all anagrams in a string
// @author: Zhen Xu
import java.util.*;
public class FindAllAnagrams {
    public static void main(String args[]) {
        String s = "abcabbaba";
        String p = "aba";
        List<Integer> list = solution(s, p);
    }
    
    public static List<Integer> solution(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            if (map.keySet().contains(p.charAt(i))) {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            } else {
                map.put(p.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int count = 0;
            // get the temp map so that we dont ruin the original map
            Map<Character, Integer> temp = new HashMap<Character, Integer>();
            temp.putAll(map);
            // test if its an anagram
            for (int j = 0; j < p.length(); j++) {
                if (temp.keySet().contains(s.charAt(i + j)) && temp.get(s.charAt(i + j)) > 0) {
                    count++;
                    System.out.println(temp.get(s.charAt(i + j)) - 1);
                    temp.put(s.charAt(i + j), temp.get(s.charAt(i + j))- 1);
                }
            }
            if (count == p.length()) {
                list.add(i);
            }
            // re-initiate
            count = 0;
            temp.putAll(map);
            
        }
        return list;
    }
}