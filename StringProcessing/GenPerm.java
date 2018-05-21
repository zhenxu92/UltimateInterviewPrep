import java.util.*;
public class GenPerm {
    public static void main(String args[]) {
        String s = "aabbcc";
        
        System.out.println(generatePalindromes(s).toString());
    }
    
    public static List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<String>();
        List<Character> charList = new ArrayList<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Set<String> set = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        
        // Judge if it is and preprocessing the map 
        int count = 0;
        String theOnly = "";
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                count++;
                theOnly += c;
            }
            for (int i = 0; i < map.get(c) / 2; i++) charList.add(c);
        }
        if (count > 1) return list;
        
        // generate permutations
        genPerm(charList, set, sb, charList.size(), theOnly);
        for (String str : set) {
            list.add(str);
        }
        
        return list;
    }
    
    public static void genPerm (List<Character> list, Set<String> set, StringBuilder sb, int length, String temp) {
        if (sb.length() == length) {
            set.add(sb.toString() + temp + sb.reverse().toString());
        }
        
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            sb.append(c);
            list.remove(i);
            genPerm(list, set, sb, length, temp);
            list.add(0, c);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}