import java.util.*;
public class SudoKuSolver {
    static int m;
    static int n;
    public static void main(String args[]) {
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.',',',','},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
         
        };
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    
    public static void solveSudoku(char[][] board) {
        m = board.length;
        n = board[0].length;
        solve(board, 0, 0);
    }
    
    public static boolean solve(char[][] board, int i, int j) {
        for (int r = i; r < m; r++) {
            for (int c = j; c < n; c++) {
                if (board[r][c] >= '1' && board[r][c] <= '9') continue;
                for (int k = 0; k < 9; k++) {
                    if (safe(board, r, c, (char)(k + '1'))) {
                        board[r][c] = (char)(k + '1');
                        if (solve(board, (r + 1) % m, c)) {
                            return true;
                        } else {
                            board[r][c] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    public static boolean safe(char[][] board, int row, int col, char c) {
        // check col
        for (int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            System.out.println((3 * (row / 3) + i / 3) + " " + (3 * (col / 3) + i % 3));
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}