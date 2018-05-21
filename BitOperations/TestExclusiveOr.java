// Exclusive-or will return zero if both digit are the same

// return 1 if not.
// 
// ex: 0101 ^ 1100 = 101

public class TestExclusiveOr {
    public static void main (String args[]) {
        int x = 3;
        System.out.println(Integer.toBinaryString(x));
        int y = 4;
        System.out.println(Integer.toBinaryString(y));
        int ans = x ^ y;
        System.out.println(Integer.toBinaryString(ans));
        int res = 0;
        if (ans == 0) {
            System.out.println(0);
        } else {
            while(ans / 2 != 0) {
                res++;
                ans /= 2;    
            }
            res++;
            
            System.out.println(res);
        }
    }
}