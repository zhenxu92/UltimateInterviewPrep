import java.util.*;
public class SortCharByFreq {
    public static void main(String args[]) {
        String s = "tree";
        System.out.println(frequencySort(s));
        
    }
    
    public static String frequencySort(String s) {
        Map<Integer, List<Character>> map = new TreeMap<>();
        int[] freq = new int[256];
        char[] seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            freq[seq[i]]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            if (!map.containsKey(freq[i])) {
                map.put(freq[i], new ArrayList<Character>());
                map.get(freq[i]).add((char)i);
            } else {
                map.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (map.keySet().iterator().hasNext()) {
            int fq = map.keySet().iterator().next();
            List<Character> list = map.get(fq);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < fq; j++) {
                    sb.append(list.get(i));
                }
            }
            // created iterator every time, so it needs removing
            // if iterator is created first, no need for removing
            map.remove(fq);
        }
        return sb.reverse().toString();
    }
}