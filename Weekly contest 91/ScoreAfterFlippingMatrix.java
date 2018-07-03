public class ScoreAfterFlippingMatrix {
    public static void main(String args[]) {
        System.out.println("Hello");
    }
    public static int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] tp = A[i];
            if (tp[0] != 1) {
                for (int j = 0; j < tp.length; j++) {
                    if (tp[j] == 0) tp[j] = 1;
                    else tp[j] = 0;
                }
            }
        }
        int n = A[0].length;
        int m = A.length;
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (A[i][j] > 0) count++;
            }
            if (count > m / 2) swap(A, i, m);
        }
        
        // calculate
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    res += Math.pow(2, n - j);
                }
            }
        }
        return res;
    }
    
    private static void swap(int[][] A, int col, int m) {
        for (int j = 0; j < m; j++) {
            if (A[j][col] == 1) A[j][col] = 0;
            else A[j][col] = 1;
        }
    }
}