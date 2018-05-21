// HighestOneBit
// @author:Zhen XU
// This program test the function of HighestOneBit method of Integer object
// Result: the highestOneBit method returns the decimal representation of the 
// highest (leftmost) one-bit. For example, 2 is 10, the leftmost or highest 
// one-bit is 1 in second digit, which represents 4. Another example, 10 is 1010,
// the highest bit is 1 one the leftmost, which represent 2^4, equals to 8.
public class HighestOneBit {
    public static void main (String args[]) {
        int input = 10;
        int output = Integer.highestOneBit(input);
        System.out.println(output);
    }    
}