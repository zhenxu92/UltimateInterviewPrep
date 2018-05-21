// LeetCode #371 Sum of Two Integers
// @author: Zhen Xu
// Use bit operation to sum two integers without using any + - * /

// trick:
// a = 1 = 0001
// b = 4 = 0100
// a ^ b = 0101, a & b = 0000, a & b << 1 = 000
// now b = 0; answer = 0101

// Explanation:
// From the calculation above, you see that, ^ operation add those digits
// which does not require plus to next digit, for example 0100 ^ 0001 ->
// 0101
// & and << operation find the bit that needs to be added to next digit and 
// add it

// a = 3 = 0011
// b = 7 = 0111
// a ^ b = 0100,a = a & b = 0011,b = a & b << 1 = 0 0110
// 
// a = 0 0011
// b = 0 0110
// a ^ b = 0 0101, a & b = 0 0010, a & b << 1 = 00 0100
// a = 0000 0010
// b = 0000 0100
//
// a
public class SumOfTwoIntegers {
    public static void main(String args[]) {
        int a = 1
        int b = 4;
        //System.out.println(Integer.toBinaryString(n));
        //System.out.println(Integer.toBinaryString(solution(n)));
    }
    
    public static int solution(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return solution(a ^ b, (a & b) << 1);
        }   
    }
}