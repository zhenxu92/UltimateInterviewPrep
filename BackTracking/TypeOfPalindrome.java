import java.util.*;
class TypeOfPalindrome {
    public static int res = 0;
    
    public static void main(String args[]) {
        String s = "aaaaccd";
        // ccccc
        longestPalindrome(s);
    }
    public static int longestPalindrome(String s) {
        // sc
        if (s == null || s.length() == 0) return 0;
        // ex.
        // abccccddA
        //
        // map
        // a -> 1
        // b -> 1
        // c -> 4
        // d -> 2
        // A -> 1
        // ds
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Character> list = new ArrayList<Character>();
        List<List<Character>> types = new ArrayList<List<Character>>();
        int numOfSingles = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.keySet().contains(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }
        
        for (char c : map.keySet()) {
            int count = map.get(c);
            int numOfChar = (count / 2);                
            if (count % 2 != 0) {
                numOfSingles++;
            }
            for (int i = 0; i < numOfChar; i++) {
                list.add(c);
            }
        }
        // a a c c d e
        // numOfSingles = 3
        boolean[] used = new boolean[list.size()];
        
        Collections.sort(list);
        backTracking(list, new ArrayList<Character>(), used);
        System.out.println(numOfSingles);
        System.out.println(res * numOfSingles);
        return res * numOfSingles;
        
    }
    public static void backTracking(List<Character> list, ArrayList<Character> tempList, boolean[] used) {
        if (tempList.size() == list.size()) {
            res++;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (used[i] || i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
                     continue;
                }
                used[i] = true;
                tempList.add(list.get(i));
                backTracking(list, tempList, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
    
    //              c 
    //          c   
    //      d
    //  e
    //  a
    //  a
}