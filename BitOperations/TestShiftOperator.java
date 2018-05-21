// TestShiftOperator v1.0
// @author Zhen Xu
// This program test the function of bit operator "<<".
// This operator actually shift every bit of a binary
// array to left. For example, 1000 << 1 -> 10000.
// 1000 << 2 -> 100000.
public class TestShiftOperator {
    public static void main (String args[]) {
        int input = 8;
        int output = input << 2;
        System.out.println(output);
    }
}