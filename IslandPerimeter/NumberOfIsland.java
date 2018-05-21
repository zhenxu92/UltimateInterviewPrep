public class NumberOfIsland {
    static int m;
    static int n;
    public static void main (String args[]) {
        int[][] grid = {{1,0,1,1,1}, {0,1,1,0,1}, {1,0,1,0,1},{1,1,0,0,0}};
        System.out.println(solution(grid));
    }
    
    public static int solution(int[][] grid) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }
    
    public static void DFSMarking(int[][] grid, int  i, int j) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1 || grid[i][j] != 1) return;
        grid[i][j] = 0;
        DFSMarking(grid, i+1, j);
        DFSMarking(grid, i-1, j);
        DFSMarking(grid, i, j+1);
        DFSMarking(grid, i, j-1);
    }
}