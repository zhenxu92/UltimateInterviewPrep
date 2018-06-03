// Zhen Xu, Phil
// GWU @DC
// Seattle-> kirkland
// 250+
// https://github.com/zhenxu92/UltimateInterviewPrep/branches
// zhenxu92
// linkedin/in/zhenxu92
// github.com/zhenxu92
// 
import java.util.*;
public class GuessWord {
    public static void main(String args[]) {
        String[] wordList = new String[]{"run", "see", "cld", "foo", "bar", "faz"};
        Master master = new Master("idol");
        guessTheWord(wordList, master);
    }
    
    public static boolean guessTheWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) for (String w2 : wordlist) if (match(w1, w2) == 0) count.put(w1, count.getOrDefault(w1 , 0) + 1);
            Pair<String, Integer> minimax = new Pair<>("", 1000);
            for (String w : wordlist) if (count.getOrDefault(w, 0) < minimax.getValue()) minimax = new Pair<>(w, count.getOrDefault(w, 0));
            x = master.guess(minimax.getKey());
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist) if (match(minimax.getKey(), w) == x) wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
    
    public static int match(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) res++;
        }
        return res;
    }
}