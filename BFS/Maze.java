import java.util.*;
public class Maze {
    public static void main(String args[]) {
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};
        String matrix = "[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]";
        IntArrayConverter iac = new IntArrayConverter(matrix);
        int[][] maze = iac.convert();
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            if (cur == destination) return true;
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // top
            int tp = y;
            while (tp > 0 && maze[x][tp - 1] != 1) {
                tp--;
            }
            q.add(new int[]{x, tp});
            // down
            tp = y;
            while (tp < n - 1 && maze[x][tp + 1] != 1) {
                tp++;
            }
            q.add(new int[]{x, tp});
            // left
            tp = x;
            while (tp > 0 && maze[tp][y] != 1) {
                tp--;
            }
            q.add(new int[]{tp, y});
            // right
            tp = x;
            while (tp < m - 1 && maze[tp + 1][y] != 1) {
                tp++;
            }
            q.add(new int[]{tp, y});
        }
        return false;
    }
}