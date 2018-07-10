import java.util.*;
public class MazeII {
    public static void main(String args[]) {
        int[] start = new int[]{4, 3};
        int[] destination = new int[]{0,1};
        String matrix = "[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]";
        IntArrayConverter iac = new IntArrayConverter(matrix);
        int[][] maze = iac.convert();
        System.out.println(shortestDistance(maze, start, destination));
    }
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vectors = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pos1, int[] pos2) {
                return pos1[2] - pos2[2];
            }
        });
        int[][] dist = new int[m][n];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int[] startPos = new int[]{start[0], start[1], 0};
        pq.add(startPos);
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int x = cur[0];
            int y = cur[1];
            int l = cur[2];
            if (dist[x][y] <= l) continue;
            dist[x][y] = l;
            for (int[] vector : vectors) {
                int xx = x;
                int yy = y;
                int ll = l;
                while (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 0) {
                    xx += vector[0];
                    yy += vector[1];
                    ll++;
                }
                xx -= vector[0];
                yy -= vector[1];
                ll--;
                pq.add(new int[]{xx, yy, ll});
            }
        }
        return (dist[destination[0]][destination[1]] == Integer.MAX_VALUE) ? -1 : dist[destination[0]][destination[1]];
    }
}