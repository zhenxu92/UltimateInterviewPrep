import java.util.*;
public class CountDuplicatesOverTwo {
    public static void main(String args[]) {
        int[] arr = new int[]{6, 1, 1, 2, 2, 3, 5, 4};
        System.out.println(countDuplicates(arr));
    }
    
    public static int countDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : arr) {
            if (!map.keySet().contains(n)) {
                map.put(n, 1);
            } else {
                int count = map.get(n);
                map.put(n, count + 1);
            }
        }
        int res = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count >= 2) {
                res++;
            }
        }
        return res;
    }
    
    
}