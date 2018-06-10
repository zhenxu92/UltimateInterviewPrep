import java.util.*;
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> list = new ArrayList<>();
        int[] res = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < richer.length; i++) {
            list.get(richer[i][1]).add(richer[i][0]);
        }

        for (int i = 0; i < res.length; i++) {
            boolean[] visited = new boolean[quiet.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int min = quiet[i];
            int ans = i;
            while (!q.isEmpty()) {
                int cur = q.remove();
                if (visited[cur]) continue;
                visited[cur] = true;
                if (quiet[cur] < min) {
                    min = quiet[cur];
                    ans = cur;
                }
                List<Integer> tempList = list.get(cur);
                for (int n : tempList) {
                    q.add(n);
                }
            }
            res[i] = ans;
        }
        return res;
    }
}