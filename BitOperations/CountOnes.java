// CountOnes V 1.0
// @author: Zhen XU
// This program takes in a integer and count the one-bit in its
// binary form.

// Basically, how it works is because in binary operations, if an
// integer is detracted by 1, it will lose one-bit in its original 
// location, thus, by AND them, it will lose one bit in its binary
// form. By doing this multiple times, it will lose all the one-bits
// which will finally make this value zero.

// 1010 - 1 = 1001, 1001 & 1010 = 1000, count = 1;
// 1000 - 1 = 0111, 0111 & 1000 = 0000, count = 2;
// There are 2 one-bit in 10.

// Some comments: I used to use % operation to test how many one-bit needed
// to represent an integer in its binary form. If a number can be divide by 
// 2, then count++, but that's actually so wrong. 
public class CountOnes {
    public static void main (String args[]) {
        int input = 10;
        int output = Solution(input);
        System.out.println(output);
    }
    
    public static int Solution(int input) {
        int n = input;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}