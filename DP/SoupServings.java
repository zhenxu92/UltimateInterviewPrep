public class SoupServings {
    public static double[][] prob = new double[200][200];
    public static void main(String args[]) {
        int N = 50;
        if (N >= 4800) {
            System.out.println(1);
        } else {
            System.out.println(f((N + 24)/25, (N + 24)/25));
        }
        
    }
    
    public static double f (int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (prob[a][b] > 0) return prob[a][b];
        prob[a][b] = 0.25 * (f(a-4, b) + f(a-3, b-1) + f(a-2, b-2) + f(a-1, b-3));
        return prob[a][b];
    }
}