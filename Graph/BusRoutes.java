import java.util.*;
public class BusRoutes {
    public static void main(String args[]) {
        int[][] routes = new int[][]{
            {1,2,7},
            {3,6,7}
        };
        
        System.out.println(numBusesToDestination(routes, 1, 6));
    }
    
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int stop = routes[i][j];
                int bus = i;
                if (!graph.containsKey(stop)) {
                    graph.put(stop, new ArrayList<Integer>());
                }
                graph.get(stop).add(bus);
            }   
        }
        
        int[] visited = new int[routes.length]; // bus visited
        Queue<Integer> q = new LinkedList<>();
        // init
        q.add(S);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int cur = q.remove();   // stop

                List<Integer> buses = graph.get(cur);
                for (Integer bus : buses) {
                    if (visited[bus] != 0) continue;
                    visited[bus] = 1;
                    for (int stop : routes[bus]) {
                        if (stop == T) return res;
                        q.add(stop);
                    }   
                }
            }
        }
        return -1;
    }
}