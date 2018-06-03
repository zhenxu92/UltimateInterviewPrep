import java.util.*;
public class SplitIntoFib {
    public static void main(String args[]) {
        String s = "123456579";
        System.out.println(splitIntoFibonacci(s).toString());
    }
    
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(S, res, 0);
        return res;
    }
    
    private static boolean helper(String s, List<Integer> res, int start) {
        if (start == s.length() && res.size() > 2) {
            return true;
        } else {
            for (int i = start; i < s.length(); i++) {
                if (i > start && s.charAt(start) == '0') break;
                long cur = Long.parseLong(s.substring(start, i + 1));
                if (cur > Integer.MAX_VALUE) break;
                int size = res.size();
                if (size >= 2 && cur > res.get(size - 1) + res.get(size - 2)) break;
                if (size <= 1 || cur == res.get(size - 1) + res.get(size - 2)) {
                    res.add((int)cur);
                    if (helper(s, res, i + 1)) return true;
                    res.remove(res.size() - 1);
                }
            }
        }
        return false;
    }
}