import java.util.*;
public class AllSubStringWithKDistinctCharacter {
    public static void main(String args[]) {
        String s = "caaab";
        int k = 2;
        String[] res = kDistinctChar(s, k);
        for (String str : res) {
            System.out.println(str);
        }
    }
    
    public static String[] kDistinctChar(String s, int k) {
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            String substr = s.substring(i, i + k);
            set.add(substr);
        }
        String[] res = new String[set.size()];
        List<String> list = new ArrayList<>();
        for (String str : set) {
            list.add(str);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}