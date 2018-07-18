import java.util.*;
public class PacificAtlanticWaterFlow {
    public static int m;
    public static int n;
    public static int[][] vecs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}}; 
    public static void main(String args[]) {
        IntArrayConverter iac = new IntArrayConverter("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]");
        int[][] matrix = iac.convert();
        List<int[]> res = pacificAtlantic(matrix);
        for (int[] pos : res) {
            System.out.println(Arrays.toString(pos));
        }
    }

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        // left & right
        for (int i = 0; i < m; i++) {
            dfs(matrix, atlantic, i, n - 1, Integer.MIN_VALUE);
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
        }
        
        // top & bottome
        for (int j = 0; j < n; j++) {
            dfs(matrix, atlantic, m - 1, j, Integer.MIN_VALUE);
            dfs(matrix, pacific, 0, j, Integer.MIN_VALUE);
        }
        
        // scan both matrix and push results into list
        List<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    
    private static void dfs(int[][] matrix, boolean[][] visited, int i, int j, int value) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;
        if (matrix[i][j] <= value) return;
        if (matrix[i][j] > value) visited[i][j] = true;
        for (int[] vec : vecs) {
            dfs(matrix, visited, i + vec[0], j + vec[1], matrix[i][j]);
        }
    }
}