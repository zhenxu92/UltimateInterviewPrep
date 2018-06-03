import java.util.*;
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        // keyset sorted
        // hash unsorted
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        int j = 0;
        while (j < hand.length / W) {
            int cur = -1;
            for (int i = 0; i < W; i++) {
                if (i == 0) {
                    cur = map.keySet().iterator().next();
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) map.remove(cur);
                } else {
                    // if consecutive not found
                    if (!map.containsKey(cur + 1)) return false;
                    // if found
                    // edit map
                    cur = cur + 1;
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) map.remove(cur);
                }
            }
            j++;
        }
        return true;
    }
    
    // private boolean isConsecutive(int[] hand, int i, int j) {
    //     for (int k = i; k < j; k++) {
    //         if (hand[k] != hand[k] + 1) return false;
    //     }
    //     return true;
    // }
}