// Power of Four
// @author: Zhen XU
// Determine if a number is power of four using bit operation

// Rationale
// Number that is power of four: 0, 4, 16, 64, 256...
// In binary form
// 0 -> 0
// 4 ->  0000 0100 in 3rd
// 16 -> 0001 0000 in 5th
// 64 -> 0100 0000 in 7th
// n > 0 : make sure it's positive
// n & (n - 1) == 0 : ensure that there is only one "1" 
// n & 0x55555555 : ensures that there is no number on even digit

import java.util.*;
public class PowerOfFour {
    public static void main (String args[]) {
        int num = 4;
        //System.out.println(Integer.toBinaryArray(0x55555555));
        // 5 -> 0101
        // 5555 -> 0101 0101 0101 0101
        // 4 -> 0100
        // 4 & 0x5555 -> 0100 & 0101 -> 0100
        // 2 & 0x5555 -> 0010 & 0101 -> 0000
        // 8 & 0x5555 -> 1000 & 0101 -> 0000
        System.out.println(solution(num));
    }
    
    public static boolean solution(int num) {
        int n = num;
        int a = n & (n - 1);
        int b = n & 0x55555555;
        return n > 0 && a == 0 && b != 0;
    }
}