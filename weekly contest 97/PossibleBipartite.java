import java.util.*;
public class PossibleBipartite {
    public static void main(String args[]) {
        int N = 4;
        int[][] dislikes = new int[][]{
            {1,2},
            {1,3},
            {2,4}
        };
        possibleBipartition(N, dislikes);
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int[] cur = dislikes[i];
            int a = cur[0];
            int b = cur[1];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<Integer>());
            }
            map.get(a).add(b);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();
        setA.add(1);
        q.add(1);
        
        while (!q.isEmpty()) {
            int cur = q.remove();
            if (!map.containsKey(cur)) continue;
            if (setA.contains(cur)) {
                for (int dis : map.get(cur)) {
                    if (setA.contains(dis)) return false;
                    setB.add(dis);
                    q.add(dis);
                }                
            } else {
                for (int dis : map.get(cur)) {
                    if (setB.contains(dis)) return false;
                    setA.add(dis);
                    q.add(dis);
                } 
            }

        }
        return true;
    }
}