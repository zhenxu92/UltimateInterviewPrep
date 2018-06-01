public class PrimeNumber {
    public static void main(String args[]) {
        int n = 100;
        prime(n);
    }
    
    // 1 and itself as factors
    // brute force
    // for number n
    // check everything before it to see if it is a factor?
    // O(n!)
    public static void prime(int n) {
    // indicate  non prime number if true
    // 0 1 2 3 4 5 6 7 8 9 10
    // T T F   T   T
        boolean[] nonprime = new boolean[n];
        // are all false
        nonprime[0] = true;
        nonprime[1] = true;
        for (int i = 2; i < n; i++) {
            if (nonprime[i] == true) continue;
            int j = i;
            while (i * j < n) {
                
                nonprime[i * j] = true;
                j++;
            }
        }   
        for (int k = 0; k < n; k++) {
            if (nonprime[k] == false) {
                System.out.print(k + " ");
            }
        }
    }
}