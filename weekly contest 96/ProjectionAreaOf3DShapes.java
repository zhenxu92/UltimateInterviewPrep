class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;
        int m = grid.length;
        int n = grid[0].length;
        int cubeExist = 0;
        int[] maxEachCol = new int[n];
        int[] maxEachRow = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                maxEachCol[j] = Math.max(height, maxEachCol[j]);
                maxEachRow[i] = Math.max(height, maxEachRow[i]);
                if (height > 0) cubeExist++;
            }
        }
        for (int max : maxEachCol) {
            res += max;
        }
        for (int max : maxEachRow) {
            res += max;
        }
        res += cubeExist;
        return res;
    }
}