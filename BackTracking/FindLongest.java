/**
* sort all the words in the dictionary,
* and then validate from the longest word.
* once find one,
* @param dict
* @param elements
* @return
*/


import java.util.*;
public class FindLongest {
    private String findLongest(Set dict, Set elements) {
        PriorityQueue<String> queue = new PriorityQueue(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if (isFormed(0, tmp, elements)) {
                return tmp;
            }
        }
        return null;
    }
    
    private boolean isFormed(int i, String word, Set elements) {
        if (i == word.length()) {
            return true;
        }
        if (elements.contains(word.substring(i, i + 1)))
        if (isFormed(i + 1, word, elements))
            return true;
        if (i < word.length() - 1) { 
            if (elements.contains(word.substring(i, i + 2))) 
                if (isFormed(i + 2, word, elements)) 
                    return true; 
        } 
        return false; 
    }
}
