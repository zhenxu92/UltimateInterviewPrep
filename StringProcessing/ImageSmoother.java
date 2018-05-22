public class ImageSmoother {
    public static int[][] res;
    public static void main(String args[]) {
        int[][] M = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        imageSmoother(M);
    }
    
    public static int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return M;
        res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                calc(i, j, M);
            }
        }
        return res;
    }
    
    private static void calc(int i, int j, int[][] M) {
        int count = M[i][j];
        int num = 1;
        // top
        if (i > 0) {
            count += M[i - 1][j];
            num++;
        }
        // left
        if (j > 0) {
            count += M[i][j - 1];
            num++;
        }
        // bottom
        if (i < M.length - 1) {
            count += M[i + 1][j];
            num++;
        }
        // right
        if (j < M[0].length - 1) {
            count += M[i][j+1];
            num++;
        }  
        // top left
        if (i > 0 && j > 0) {
            count += M[i-1][j-1];
            num++;
        }
        // bottom right
        if (j < M[0].length - 1 && i < M.length - 1) {
            count += M[i + 1][j + 1];
            num++;
        }
        // top right
        if (i > 0 && j < M[0].length - 1) {
            count += M[i - 1][j + 1]; 
            num++;
        }
        // bottom left
        if (i < M.length - 1 && j > 0) {
            count += M[i + 1][j - 1];
            num++;
        }
        int ans = (int)Math.floor(count * 1.0 / num);
        res[i][j] = ans;
    }
}