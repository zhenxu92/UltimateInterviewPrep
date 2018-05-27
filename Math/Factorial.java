public class Factorial {
    public static void main(String args[]) {
        int n = 1;
        System.out.println(factorial(n));
    }
    
    private static int factorial(int n) {
        int res = n;
        n = n - 1;
        while (n > 0) {
            res = res * n;
            n--;
        }
        return res;
    }
}