// #396
// F(k) = 0 * Bk[0] + 1 * Bk[1] + 2 * Bk[2] + ... + (n - 1) * Bk[n - 1]
// Bk[i] = Bk-1[i - 1]
// F(k - 1) = 0 * Bk[n] + 1 * Bk[0] + 2 * Bk[1] + ... + (n - 1) * Bk[n - 2]
// F(k) - F(k - 1) = Bk[1] + Bk[2] + ... + Bk[n - 1] + (1 - n) * Bk[0]
// F(k) = F(k - 1) + (Bk[0] + Bk[1] + ... + Bk[n - 1]) - nBk[0]
// F(k) = F(k - 1) + sum + n * Bk[0]
// k = 0, Bk[0] = A[0]
// k = 1, Bk[0] = A[len - 1]
// k = 2, ...
//

class RotateFunction {
    public static void main(String args[]) {
        int[] a = new int[]{4,3,2,6};
        System.out.println(maxRotateFunction(a));
    }

    public static int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        
        int cur = 0;
        // calc F[0]
        for (int i = 0; i < A.length; i++) {
            cur += i * A[i];
        }
        int max = cur;
        // calc Fk and compare
        for (int i = 1; i < A.length; i++) {
            int temp = cur + sum - n * A[n - i];
            max = Math.max(temp, max);
            cur = temp;
        }
        return max;
    }
}