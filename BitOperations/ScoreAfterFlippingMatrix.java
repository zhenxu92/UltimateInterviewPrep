public class ScoreAfterFlippingMatrix {
    public static void main(String args[]) {
        int[][] A = new int[][]{
            {0,0,1,1},
            {1,0,1,0},
            {1,1,0,0}
        };
        
        System.out.println(matrixScore(A));
    }
    public static int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = 0;
        for (int c = 0; c < n; c++) {
            int max = 0;
            for (int r = 0; r < m; r++) {
                max += A[r][c] ^ A[r][0];
            }
            res += Math.max(max, m - max) * (1 << (n - 1 - c));
        }
        return res;
    }
}