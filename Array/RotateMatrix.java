import java.util.*;
public class RotateMatrix {
    public static void main(String args[]) {
        int[][] matrix = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        // diag transpose
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                matrix[i][j] = matrix[j][i] ^ matrix[i][j];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[j][i] ^ matrix[i][j];
            }
        }
        
        // vertical sym
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                matrix[i][j] ^= matrix[i][m - j - 1];
                matrix[i][m - j - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][m - j - 1];
            }
        }
    }
}