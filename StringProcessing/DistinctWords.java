// DistinctWords
// @author: Zhen Xu
// This program could detect how many distinct words are there in some text,
// any space, punctuations will be ignored.
// Implementation: Basically, just split the string so that only words remains,
// then put all those words in a map to eliminate duplications. The size of keySet()
// is the total number of distinct words.
import java.util.*;
public class DistinctWords {
    public static void main (String args[]) {
        String input = "he should be here, he should not be about, put me down said the fish, tell that cat in the hat";
        int count = countDistinctWords(input);
        System.out.println(count);
    }
    
    public static int countDistinctWords(String input) {
        String[] source = input.split("[ ,.]+");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String token : source) {
            map.put(token, 1);
        }
        int count = map.keySet().size();
        return count;       
    }
}