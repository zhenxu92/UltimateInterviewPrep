import java.util.*;
public class frequencySort {
    public static void main(String args[]) {
        String s = "cccaaa";
        System.out.println(solution(s));
    }
    
    public static String solution(String s) {
        
        // Hash map
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.keySet().contains(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            maxCount = Math.max(maxCount, map.get(s.charAt(i)));
        }
        
        // store in array of list, the content in the list stores the character that
        // has such frequency.
        List<Character>[] arr = new List[maxCount+1];
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (arr[count] == null) {
                arr[count] = new ArrayList<Character>();
            }
            arr[count].add(c);
        }
        
        
        // out put it
        String str = "";
        for (int i = arr.length - 1; i > 0; i--) {
            List<Character> list = arr[i];
            // j is the number of character
            if(list != null) {
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < i; k++) {
                        str += list.get(j);
                    }
                }            
            }

        }
        
        return str;
    }
}