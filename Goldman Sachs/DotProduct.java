public class DotProduct {
    public static void main(String args[]) {
        // 2*3
        int[][] a = new int[][]{
            {1,2,3},
            {4,5,6}
        };
        // 3*2
        int[][] b = new int[][]{
            {1,2},
            {3,4},
            {5,6}
        };
        // 2*2
        int[][] res = dotProduct(a, b);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] dotProduct(int[][] a, int[][] b) {
        int ma = a.length;
        int na = a[0].length;
        int mb = b.length;
        int nb = b[0].length;
        int[][] res = new int[ma][nb];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < nb; j++) {
                // i row from a * j col from b
                // 
                int sum = 0;
                for (int k = 0; k < na; k++) {
                    int left = a[i][k];
                    int right = b[k][j];
                    sum += left * right;
                }
                res[i][j] = sum;
            }
        } 
        return res;   
    }
}