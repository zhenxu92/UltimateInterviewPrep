import java.util.*;
public class Maze {
    public static void main(String args[]) {
        int[] start = new int[]{0, 0};
        int[] destination = new int[]{8,6};
        String matrix = "[[0,0,0,0,1,0,0],[0,0,1,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,1],[0,1,0,0,0,0,0],[0,0,0,1,0,0,0],[0,0,0,0,0,0,0],[0,0,1,0,0,0,1],[0,0,0,0,1,0,0]]";
        IntArrayConverter iac = new IntArrayConverter(matrix);
        int[][] maze = iac.convert();
        System.out.println(hasPath(maze, start, destination));
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // top
            int tp = x;
            while (tp > 0 && maze[tp - 1][y] != 1) {
                tp--;
            }
            q.add(new int[]{tp, y});
            // down
            tp = x;
            while (tp < m - 1 && maze[tp + 1][y] != 1) {
                tp++;
            }
            q.add(new int[]{tp, y});
            // left
            tp = y;
            while (tp > 0 && maze[x][tp - 1] != 1) {
                tp--;
            }
            q.add(new int[]{x, tp});
            // right
            tp = y;
            while (tp < n - 1 && maze[x][tp + 1] != 1) {
                tp++;
            }
            q.add(new int[]{x, tp});
        }
        return false;
    }
}