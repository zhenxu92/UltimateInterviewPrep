import java.util.*;
public class MazeIII {
    public static void main(String args[]) {
        int[] ball = new int[]{4,3};
        int[] hole = new int[]{0,1};
        String matrix = "[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]";
        IntArrayConverter iac = new IntArrayConverter(matrix);
        int[][] maze = iac.convert();
        System.out.println(shortestDistance(maze, ball, hole));
    }
    public static String shortestDistance(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vectors = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        
        String[] dirs = new String[]{"d", "r", "u", "l"};
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.l - p2.l;
            }
        });
        Point[][] dist = new Point[m][n];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = new Point(i, j, Integer.MAX_VALUE, "");
            }
        }
        Point ballPos = new Point(ball[0], ball[1], 0, "");
        pq.add(ballPos);
        while (!pq.isEmpty()) {
            Point cur = pq.remove();
            int x = cur.x;
            int y = cur.y;
            int l = cur.l;
            String s = cur.s;
            if (dist[x][y].l <= l) continue;
            System.out.println(cur.x + ", " + cur.y + ", " + cur.l + ", " + cur.s);
            dist[x][y] = new Point(x, y, l, s);
            System.out.println(dist[x][y].l + ", " + dist[x][y].s);
            for (int i = 0; i < vectors.length; i++) {
                int[] vector = vectors[i];
                int xx = x;
                int yy = y;
                int ll = l;
                String ss = s;
                while (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 0 && (xx != hole[0] || yy != hole[1])) {
                    xx += vector[0];
                    yy += vector[1];
                    ll++;
                }
                if (xx != hole[0] || yy != hole[1]) {
                    xx -= vector[0];
                    yy -= vector[1];
                    ll--;
                }
                ss += dirs[i];
                pq.add(new Point(xx, yy, ll, ss));
                //System.out.println(xx + ", " + yy + ", " + ss + ", " + ll);
            }
            System.out.println("processed one");
        }
        System.out.println(dist[hole[0]][hole[1]].l);
        return (dist[hole[0]][hole[1]].l == Integer.MAX_VALUE) ? "impossible" : dist[hole[0]][hole[1]].s;
    }
    
    static class Point {
        int x;
        int y;
        int l;
        String s;
        
        public Point(int x, int y, int l, String s) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.s = s;
        }
    }
}