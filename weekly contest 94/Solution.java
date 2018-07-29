import java.util.*;
class Solution {
    private static int res = Integer.MIN_VALUE;
    public static void main(String args[]) {
    
        int[] arr = new int[]{2,4,7,8,9,10,14,15,18,23,32,50};
        int[] arr2 = new int[]{1,3,7,11,12,14,18};
        System.out.println();
        System.out.println(lenLongestFibSubseq(arr));
    }


    public static int lenLongestFibSubseq(int[] A) {
        int[] arr = A;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        
        dfs(arr, map, 1, 0, 0, 0);
        System.out.println(res);
        return res;
    }
    
    private static void dfs(int[] arr, Map<Integer, Integer> map, int level, int prev, int cur, int start) {
        if (start >= arr.length) return;       
        for (int i = start; i < arr.length; i++) {
            prev = cur;
            cur = arr[i];
            System.out.print("[" + prev + ", " + cur + "] ");
            int sum = cur + prev;
            if (level >= 2) {
                if (!map.containsKey(sum)) {
                    res = Math.max(res, level);
                    continue;
                    //return;
                }
                int pos = map.get(sum);
                dfs(arr, map, level + 1, prev, cur, pos);
            } else {
                dfs(arr, map, level + 1, prev, cur, i + 1);    
            }
            System.out.println();
        }
    }
}