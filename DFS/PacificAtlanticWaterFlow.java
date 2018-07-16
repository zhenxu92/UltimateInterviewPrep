public class PacificAtlanticWaterFlow {
    public static int m;
    public static int n;

    public static void main(String args[]) {
        IntArrayConverter iac = new IntArrayConverter("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]");
        int[][] matrix = iac.convert();
        List<int[]> res = pacificAtlantic(matrix);
        System.out.println(res.toString());
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] atFlowTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            atFlowTo[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            atFlowTo[m][j - 1] = true;
        }
        dfs(matrix, atFlowTo, m - 1, n - 1);
    }
    
    private void dfs(int[][] matrix, boolean[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
    }
}