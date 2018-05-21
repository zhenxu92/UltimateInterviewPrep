public class WordSearch {
    public static void main(String args[]) {
        char[][] board = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == w[0]) {
                    return dfs(w, board, i, j, 0);
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(char[] w, char[][] board, int i, int j, int start) {
        if (start == w.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if (board[i][j] != w[start]) return false;
        board[i][j] ^= 256;
        boolean exist = dfs(w, board, i - 1, j, start + 1) || dfs(w, board, i + 1, j, start + 1) || dfs(w, board, i, j - 1, start + 1) || dfs(w, board, i, j + 1, start + 1);
        board[i][j] ^= 256;
        return exist;
    }
}