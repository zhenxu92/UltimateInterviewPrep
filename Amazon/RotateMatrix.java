import java.util.*;
public class RotateMatrix {
    public static void main(String args[]) {
        IntArrayConverter iac = new IntArrayConverter("[[1,2,3],[4,5,6],[7,8,9]]");
        int[][] matrix = iac.convert();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        rotate(matrix, 1);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    
    // rotate a n * n matrix clockwise or counterclockwise,
    // flag == 1, means clockwise, flag == 0, means counterclockwise
    public static void rotate(int[][] matrix, int flag) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        transpose(matrix);
        
        if (flag == 1) {
        // horizontal sym
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length / 2; j++) {
                    swap(matrix, i, j, i, n - 1 - j);
                }
            }
        } else {
        // vertical sym
            for (int j = 0; j < n; j++)
                for (int i = 0; i < m / 2; i++) {
                    swap(matrix, i, j, m - i - 1, j);
                }
            }
        }
        public static void transpose(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[0].length; j++) {
                    swap(matrix, i, j, j, i);
                }
            }   
        }
    
        public static void swap(int[][] matrix, int a, int b, int c, int d) {
            int tp = matrix[a][b];
            matrix[a][b] = matrix[c][d];
            matrix[c][d] = tp;
        }
}
     
