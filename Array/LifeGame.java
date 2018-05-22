public class LifeGame {
    public static int[][] next;
    public static void main(String args[]) {
        int[][] board = new int[][]{
            {1}
        };
        gameOfLife(board);
        
        
    }
    public static void gameOfLife(int[][] board) {
        next = new int[board.length][board[0].length];
        if (board == null || board.length == 0 || board[0].length ==0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                check(i, j, board);
            }
        }
        board = next;
    }
    
    private static void check(int i, int j, int[][] board) {
        int count = 0;
        if (i > 0) if (board[i - 1][j] == 1) count++;
        if (j > 0) if (board[i][j - 1] == 1) count++;
        if (i < board.length - 1) if (board[i + 1][j] == 1) count++;
        if (j < board[0].length - 1) if (board[i][j + 1] == 1) count++;
        if (i > 0 && j > 0) if (board[i - 1][j - 1] == 1) count++;
        if (j < board[0].length - 1 && i < board.length - 1) if (board[i + 1][j + 1] == 1) count++;
        if (i > 0 && j < board[0].length - 1) if (board[i - 1][j + 1] == 1) count++;
        if (i < board.length - 1 && j > 0) if (board[i + 1][j - 1] == 1) count++;
        if (board[i][j] == 0 && count == 3) next[i][j] = 1;
        if (board[i][j] == 1) {
            if (count < 2) next[i][j] = 0;
            else if (count >= 2 && count <=3) next[i][j] = 1;
            else {
                next[i][j] = 0;
            }
        }
    }
}