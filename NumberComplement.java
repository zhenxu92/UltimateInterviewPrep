// NumberComplement V 1.0
// @author: Zhen Xu
// This program takes in a integer so that we know its binary form.
// Flip each bits then return the represented integer of fliped binary
// array.


public class NumberComplement {
    public static void main (String args[]) {
        int input = 5;
        int result = findComplement(input);
        System.out.println(result);
    }
    
    public static int findComplement(int input) {
        int n = input;
        String resstr = "";
        if (n == 0) {
            return 1;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                resstr = "0" + resstr;    
            } else {
                resstr = "1" + resstr;
            }
            n = n / 2;
        }
        // test if the function parseInt ignore the 0 at the front
        // System.out.println(resstr);  
        // Yes, parseInt ignore the 0 at front.
        int output = Integer.parseInt(resstr, 2);
        return output;
    }
}