public class MaxMinPath {
    public int res = Integer.MAX_VALUE;

    public static void main(String args[]) {
        int[][] matrix = new int[][]{
            {8,4,7},
            {6,5,9},
            {6,3,8}
        };
        
        System.out.println(maxMinPath(matrix));
    }
    
    public static int maxMinPath(int[][] matrix) {
        int rmin = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = Math.min(matrix[i][0], rmin);
            rmin = Math.min(matrix[i][0], rmin);
        }
        rmin = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] < rmin) {
                rmin = matrix[0][i];
            } else {
                matrix[0][i] = rmin;
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i][j]);
            }
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        return matrix[m][n];
    }
    
    // method 2 that use a dfs algo to solve this problem
    public static int maxMinPath2(int[][] matrix) {
        dfs(matrix, 0, 0);
        return res;
    }
    
    public static void dfs(int[][] matrix, int i, int j) {
        // do something with the res
        if (matrix[i][j] < res) {
            res = matrix[i][j];
        }
        dfs(
    }
}