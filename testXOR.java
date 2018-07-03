import java.util.*;
public class testXOR {
    public static void main(String args[]) {
        int n = 1000000;
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            xor(1, 0);
            xor(1, 1);
            xor(0, 0);
            xor(0, 1); 
        }
        long endTime = System.nanoTime();
        
        long timeXOR = endTime - startTime;
        System.out.println(timeXOR / 1000000);
        
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            check(1, 0);
            check(1, 1);
            check(0, 0);
            check(0, 1); 
        }
        endTime = System.nanoTime();
        long timeCheck = endTime - startTime;
        System.out.println(timeCheck / 1000000);
    }
    
    public static int xor(int a, int b) {
        return a ^ b;
    }
    
    public static int check(int a, int b) {
        if (a == b) {
            return 0;
        } else {
            return 1;
        }
    }
}