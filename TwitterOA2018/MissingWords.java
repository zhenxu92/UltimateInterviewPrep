import java.util.*;
public class MissingWords {

    public static void main(String args[]) {
        String s = "I am am using HackerRank to improve improve programming ";
        String t = " I am ";
        System.out.println(missingWords(s, t).toString());
    }

    // Complete the missingWords function below.
    static List<String> missingWords(String s, String t) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] tarr = t.trim().split("\\s+");
        for (String str : tarr) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        Set<String> set = new HashSet<>();
        for (String str : tarr) {
            set.add(str);
        }
        
        String[] sarr = s.trim().split(" ");
        // List<String> list = new ArrayList(Arrays.asList(sarr));
        for (int i = 0; i < sarr.length; i++) {
            String temp = sarr[i];
            if (map.containsKey(temp)) {
                sarr[i] = "";
                int count = map.get(temp);
                count--;
                map.put(temp, count);
                if (count == 0) map.remove(temp);
            }
        }
        
        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] != "") res.add(sarr[i]);
        }

        return res;
    }
}